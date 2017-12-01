package com.tube.core;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tube.utils.ByteUtils;
import com.tube.utils.IoUtils;

/**
 * httpClient下载不能超过2G，因为Integer.MAX_VALUE决定
 * @author wangzx
 *
 */
public class Downloader {
	
	private static Logger logger = LoggerFactory.getLogger(Downloader.class);

	private String url;
	private String title;
	private long totalSize;
	private String ext;
	
	public Downloader(String url, String title, long totalSize, String ext) {
		this.url = url;
		this.title = title;
		this.totalSize = totalSize;
		this.ext = ext;
	}
	
	public void execute() {
		String url = URLDecoder.decode(this.url);
		CloseableHttpClient httpclient = HttpClientFactory.getCustomHttpClient("127.0.0.1", 62116);
		
		HttpGet httpGet = new HttpGet(url);
		try {
			CloseableHttpResponse response = httpclient.execute(httpGet);
			if(response.getStatusLine().getStatusCode() == 200) {
				logger.info("正在进入下载，此时网络正常");
				HttpEntity httpEntity = response.getEntity();
				FileOutputStream fileOut = new FileOutputStream(title + "." + ext); // 保存的文件名
				
				IoUtils.copyByNIO(httpEntity.getContent(), fileOut, IoUtils.DEFAULT_BUFFER_SIZE, new StreamProgress() {

					@Override
					public void start() {
						logger.info("{}开始下载", title);
					}

					@Override
					public void progress(long progressSize) {
						logger.info("{}已下载{}, 百分比是{}", title, ByteUtils.bytes2kb(progressSize), ((float)progressSize/(float)totalSize *100) + "%");
					}

					@Override
					public void finish() {
						logger.info("{}完成下载", title);
					}
					
				});
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
