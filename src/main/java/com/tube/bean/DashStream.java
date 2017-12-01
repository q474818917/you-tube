package com.tube.bean;

import java.util.List;

public class DashStream {
	private String quality;
	private String itag;
	private String type;
	private String mime;
	private String container;
	private List<String> src;
	private String size;
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getItag() {
		return itag;
	}
	public void setItag(String itag) {
		this.itag = itag;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMime() {
		return mime;
	}
	public void setMime(String mime) {
		this.mime = mime;
	}
	public String getContainer() {
		return container;
	}
	public void setContainer(String container) {
		this.container = container;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public List<String> getSrc() {
		return src;
	}
	public void setSrc(List<String> src) {
		this.src = src;
	}
	
}
