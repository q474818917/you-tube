package com.tube;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.tube.bean.DashStream;
import com.tube.bean.SourceInfo;
import com.tube.bean.VideoFormat;
import com.tube.core.Downloader;
import com.tube.core.HttpClientFactory;
import com.tube.processor.MergeFFmpegProcessor;
import com.tube.utils.ByteUtils;

/**
 * 正则发现两种模式，直接匹配获取匹配不上，需要查找匹配
 * @author wangzx
 *
 */
public class UrlParser {
	
	private static Logger logger = LoggerFactory.getLogger(UrlParser.class);
	private static final String REGEX = "ytplayer.config\\s*=\\s*([^\n]+?});";
	private static final String URL = "https://www.youtube.com/watch?v=V9gai13qRHo";
	
	public static void main(String[] args) {
		CloseableHttpClient httpclient = HttpClientFactory.getCustomHttpClient("127.0.0.1", 62116);
		HttpGet httpGet = new HttpGet(URL);
		String responseContent = "";
		try {
			CloseableHttpResponse response = httpclient.execute(httpGet);
			
			if(response.getStatusLine().getStatusCode() == 200) {
				logger.info("分析下载地址，此时网络正常");
				HttpEntity httpEntity = response.getEntity();
				responseContent = EntityUtils.toString(httpEntity, "utf-8");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<DashStream> dashStreamList = Lists.newArrayList();
		String title = "";
		
		SourceInfo sourceInfo = JSONObject.parseObject(findRegex(responseContent, REGEX), SourceInfo.class);
		title = sourceInfo.getArgs().getTitle();
		String[] streamArrays = sourceInfo.getArgs().getUrl_encoded_fmt_stream_map().split(",");
		
		String[] fmtArrays = sourceInfo.getArgs().getAdaptive_fmts().split(",");
		List<VideoFormat> list = Lists.newArrayList();
		for(String fmt : fmtArrays) {
			VideoFormat videoFormat = new VideoFormat();
			Class clazz = videoFormat.getClass();
			
			String[] valueString = fmt.split("&");
			
			for(String quote : valueString) {
				String[] quoteString = quote.split("=");
				if(quoteString.length == 1) {
					//valueMap.put(quoteString[0], "");
				}else {
					//valueMap.put(quoteString[0], quoteString[1]);
					try {
						Field field = clazz.getDeclaredField(quoteString[0]);
						field.setAccessible(true);
						field.set(videoFormat, URLDecoder.decode(quoteString[1]));
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchFieldException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			list.add(videoFormat);
		}
		
		printInfo(list);
		Scanner sc = new Scanner(System.in);   
	    System.out.println("enter your favorite itag...");   
	    String inputItag = sc.nextLine(); 
	    
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
			
		for(DashStream dashStream : dashStreamList) {
			if(dashStream.getItag().equals(inputItag)) {
				for(String url : dashStream.getSrc()) {
					Downloader downloader = new Downloader(url, title + dashStream.getSrc().indexOf(url), Long.parseLong(dashStream.getSize()), "mp4");
					downloader.execute();
				}
				
				MergeFFmpegProcessor mergeFFmpegProcessor = new MergeFFmpegProcessor(title + "0.mp4", title + "1.mp4", title + ".mp4");
				mergeFFmpegProcessor.execute();
			}
		}
	}
	
	public static void printInfo(List<VideoFormat> videoFormatList) {
		videoFormatList.stream().forEach(videoFormat -> {
			logger.info("itag -> {}, resolution -> {}, size -> {}, ext ->{}", videoFormat.getItag(), 
					videoFormat.getSize(), 
					ByteUtils.bytes2kb(Long.parseLong(videoFormat.getClen())), videoFormat.getType());
		});
	}
	
	public static String findRegex(String sourceString, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(sourceString);
		while(matcher.find()) {
			return matcher.group(1);
		}
		return null;
	}
	
}
