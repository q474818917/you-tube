package com.tube;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tube.bean.DashStream;
import com.tube.core.Downloader;
import com.tube.core.HttpClientFactory;
import com.tube.parser.Parser;
import com.tube.parser.YoutubeParser;
import com.tube.processor.MergeFFmpegProcessor;

/**
 * 正则发现两种模式，直接匹配获取匹配不上，需要查找匹配
 * @author wangzx
 *
 */
public class UrlParser {
	
	private static Logger logger = LoggerFactory.getLogger(UrlParser.class);
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
		
		Parser parser = new YoutubeParser();
		List<DashStream> dashStreamList = parser.parse(responseContent);
		
		Scanner sc = new Scanner(System.in);   
	    System.out.println("enter your favorite itag...");   
	    String inputItag = sc.nextLine(); 
	    
		for(DashStream dashStream : dashStreamList) {
			if(dashStream.getItag().equals(inputItag)) {
				for(String url : dashStream.getSrc()) {
					Downloader downloader = new Downloader(url, 
							dashStream.getTitle() + dashStream.getSrc().indexOf(url), Long.parseLong(dashStream.getSize()), dashStream.getContainer());
					downloader.execute();
				}
				
				MergeFFmpegProcessor mergeFFmpegProcessor = new MergeFFmpegProcessor(dashStream.getTitle() + "0." + dashStream.getContainer(), 
						dashStream.getTitle() + "1." + dashStream.getContainer(), dashStream.getTitle() + "." + dashStream.getContainer());
				mergeFFmpegProcessor.execute();
			}
		}
	}
	
}
