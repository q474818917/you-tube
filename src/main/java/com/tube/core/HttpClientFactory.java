package com.tube.core;

import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClientFactory {
	
	public static CloseableHttpClient getDefaultHttpClient() {
		return HttpClients.createDefault();
	}
	
	public static CloseableHttpClient getCustomHttpClient(String host, int port) {
		return HttpClients.custom().setProxy(new HttpHost(host, port)).build();
	}
	
}
