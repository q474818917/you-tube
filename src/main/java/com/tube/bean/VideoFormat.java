package com.tube.bean;

public class VideoFormat {
	
	private String projection_type;
	private String url;
	private String xtags;
	private String itag;
	private String clen;
	private String quality_label;
	private String index;
	private String type;
	private String codecs;
	private String bitrate;
	private String size;
	private String lmt;
	private String fps;
	private String init;
	
	public String getProjection_type() {
		return projection_type;
	}
	public void setProjection_type(String projection_type) {
		this.projection_type = projection_type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getXtags() {
		return xtags;
	}
	public void setXtags(String xtags) {
		this.xtags = xtags;
	}
	public String getItag() {
		return itag;
	}
	public void setItag(String itag) {
		this.itag = itag;
	}
	public String getClen() {
		return clen;
	}
	public void setClen(String clen) {
		this.clen = clen;
	}
	public String getQuality_label() {
		return quality_label;
	}
	public void setQuality_label(String quality_label) {
		this.quality_label = quality_label;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCodecs() {
		return codecs;
	}
	public void setCodecs(String codecs) {
		this.codecs = codecs;
	}
	public String getBitrate() {
		return bitrate;
	}
	public void setBitrate(String bitrate) {
		this.bitrate = bitrate;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getLmt() {
		return lmt;
	}
	public void setLmt(String lmt) {
		this.lmt = lmt;
	}
	public String getFps() {
		return fps;
	}
	public void setFps(String fps) {
		this.fps = fps;
	}
	public String getInit() {
		return init;
	}
	public void setInit(String init) {
		this.init = init;
	}
	
	@Override
	public String toString() {
		return "VideoFormat [projection_type=" + projection_type + ", url=" + url + ", xtags=" + xtags + ", itag="
				+ itag + ", clen=" + clen + ", quality_label=" + quality_label + ", index=" + index + ", type=" + type
				+ ", codecs=" + codecs + ", bitrate=" + bitrate + ", size=" + size + ", lmt=" + lmt + ", fps=" + fps
				+ ", init=" + init + "]";
	}
	
	
}
