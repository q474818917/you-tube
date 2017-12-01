package com.tube.parser;

import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.tube.bean.DashStream;
import com.tube.bean.SourceInfo;
import com.tube.bean.VideoFormat;
import com.tube.utils.ByteUtils;

public class YoutubeParser extends AbstractParser {
	
	private static Logger logger = LoggerFactory.getLogger(YoutubeParser.class);
	private static final String REGEX = "ytplayer.config\\s*=\\s*([^\n]+?});";

	@Override
	public List<DashStream> parse(String content) {
		List<DashStream> dashStreamList = Lists.newArrayList();
		
		SourceInfo sourceInfo = JSONObject.parseObject(findRegex(content, REGEX), SourceInfo.class);
		String title = sourceInfo.getArgs().getTitle();
		String[] streamArrays = sourceInfo.getArgs().getUrl_encoded_fmt_stream_map().split(",");
		
		String[] fmtArrays = sourceInfo.getArgs().getAdaptive_fmts().split(",");
		List<VideoFormat> list = Lists.newArrayList();
		for(String fmt : fmtArrays) {
			VideoFormat videoFormat = new VideoFormat();
			Class clazz = videoFormat.getClass();
			
			String[] valueString = fmt.split("&");
			for(String quote : valueString) {
				String[] quoteString = quote.split("=");
				if(quoteString.length != 1) {
					try {
						Field field = clazz.getDeclaredField(quoteString[0]);
						field.setAccessible(true);
						field.set(videoFormat, URLDecoder.decode(quoteString[1]));
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (NoSuchFieldException e) {
						e.printStackTrace();
					} catch (SecurityException e) {
						e.printStackTrace();
					}
				}
			}
			list.add(videoFormat);
		}
		
		printInfo(list);
		
		list.stream().forEach(videoFormat -> {
			videoFormat.setUrl(videoFormat.getUrl() + "&ratebypass=yes");
		});
		
		String dashMp4Url = "";
		String dashWebmUrl = "";
		String dashMp4Size = "";
		String dashWebmSize = "";
		//audio
		for(VideoFormat videoFormat : list) {
			if(videoFormat.getType().startsWith("audio/mp4")) {
				dashMp4Url = videoFormat.getUrl();
				dashMp4Size = videoFormat.getClen();
			}else if(videoFormat.getType().startsWith("audio/webm")) {
				dashWebmUrl = videoFormat.getUrl();
				dashWebmSize = videoFormat.getClen();
			}
		}
		
		//video
		for(VideoFormat videoFormat : list) {
			DashStream dashStream = new DashStream();
			dashStream.setTitle(title);
			if(videoFormat.getType().startsWith("video/mp4")) {
				dashStream.setMime("video/mp4");
				dashStream.setQuality(videoFormat.getSize());
				dashStream.setType("video/mp4");
				dashStream.setItag(videoFormat.getItag());
				dashStream.setContainer("mp4");
				dashStream.setSrc(Lists.newArrayList(videoFormat.getUrl(), dashMp4Url));
				dashStream.setSize(String.valueOf(Integer.parseInt(videoFormat.getClen()) + Integer.parseInt(dashMp4Size)));
				dashStreamList.add(dashStream);
			} else if(videoFormat.getType().startsWith("video/webm")) {
				dashStream.setMime("video/webm");
				dashStream.setQuality(videoFormat.getSize());
				dashStream.setType("video/webm");
				dashStream.setItag(videoFormat.getItag());
				dashStream.setContainer("webm");
				dashStream.setSrc(Lists.newArrayList(videoFormat.getUrl(), dashWebmUrl));
				dashStream.setSize(String.valueOf(Integer.parseInt(videoFormat.getClen()) + Integer.parseInt(dashWebmSize)));
				dashStreamList.add(dashStream);
			}
		}
		return dashStreamList;
	}

	private String findRegex(String sourceString, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(sourceString);
		while(matcher.find()) {
			return matcher.group(1);
		}
		return null;
	}
	
	private void printInfo(List<VideoFormat> videoFormatList) {
		videoFormatList.stream().forEach(videoFormat -> {
			logger.info("itag -> {}, resolution -> {}, size -> {}, ext ->{}", videoFormat.getItag(), 
					videoFormat.getSize(), 
					ByteUtils.bytes2kb(Long.parseLong(videoFormat.getClen())), videoFormat.getType());
		});
	}
	
	
}
