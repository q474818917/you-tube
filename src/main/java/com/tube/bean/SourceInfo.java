package com.tube.bean;

public class SourceInfo {
	
	private Assets assets;
	private String min_version;
	private Args args;
	private String html5;
	private String url;
	private String sts;
	private Params params;
	private Attrs attrs;
	
	
	public Assets getAssets() {
		return assets;
	}

	public void setAssets(Assets assets) {
		this.assets = assets;
	}

	public String getMin_version() {
		return min_version;
	}

	public void setMin_version(String min_version) {
		this.min_version = min_version;
	}

	public Args getArgs() {
		return args;
	}

	public void setArgs(Args args) {
		this.args = args;
	}

	public String getHtml5() {
		return html5;
	}

	public void setHtml5(String html5) {
		this.html5 = html5;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSts() {
		return sts;
	}

	public void setSts(String sts) {
		this.sts = sts;
	}

	public Params getParams() {
		return params;
	}

	public void setParams(Params params) {
		this.params = params;
	}

	public Attrs getAttrs() {
		return attrs;
	}

	public void setAttrs(Attrs attrs) {
		this.attrs = attrs;
	}

	public class Assets {
		private String css;
		private String js;
		public String getCss() {
			return css;
		}
		public void setCss(String css) {
			this.css = css;
		}
		public String getJs() {
			return js;
		}
		public void setJs(String js) {
			this.js = js;
		}
	}
	
	public class Args {
		private String player_error_log_fraction;
		private String external_play_video;
		private String apiary_host;
		private String innertube_context_client_version;
		private String video_id;
		private String gapi_hint_params;
		private String xhr_apiary_host;
		private String ppv_remarketing_url;
		private String eventid;
		private String ssl;
		private String vm;
		private String keywords;
		private String allow_embed;
		private String idpj;
		private String account_playback_token;
		private String cr;
		private String host_language;
		private String author;
		private String csi_page_type;
		private String cl;
		private String c;
		private String thumbnail_url;
		private String adaptive_fmts;
		private String of;
		private String watermark;
		private String enablecsi;
		private String storyboard_spec;
		private String loudness;
		private String is_listed;
		private String plid;
		private String fexp;
		private String pltype;
		private String token;
		private String fflags;
		private String ucid;
		private String title;
		private String itct;
		private String tmi;
		private String pyv_ad_channel;
		private String videostats_playback_base_url;
		private String fmt_list;
		private String vss_host;
		private String watch_xlb;
		private String url_encoded_fmt_stream_map;
		private String player_response;
		private String no_get_video_log;
		private String timestamp;
		private String vmap;
		private String ismb;
		private String cver;
		private String length_seconds;
		private String t;
		private String relative_loudness;
		private String avg_rating;
		private String atc;
		private String ptk;
		private String show_pyv_in_related;
		private String view_count;
		private String apiary_host_firstparty;
		private String swf_player_response;
		private String ldpj;
		private String enablejsapi;
		private String loaderUrl;
		private String innertube_api_version;
		private String hl;
		private String innertube_api_key;
		private String allow_ratings;
		public String getPlayer_error_log_fraction() {
			return player_error_log_fraction;
		}
		public void setPlayer_error_log_fraction(String player_error_log_fraction) {
			this.player_error_log_fraction = player_error_log_fraction;
		}
		public String getExternal_play_video() {
			return external_play_video;
		}
		public void setExternal_play_video(String external_play_video) {
			this.external_play_video = external_play_video;
		}
		public String getApiary_host() {
			return apiary_host;
		}
		public void setApiary_host(String apiary_host) {
			this.apiary_host = apiary_host;
		}
		public String getInnertube_context_client_version() {
			return innertube_context_client_version;
		}
		public void setInnertube_context_client_version(String innertube_context_client_version) {
			this.innertube_context_client_version = innertube_context_client_version;
		}
		public String getVideo_id() {
			return video_id;
		}
		public void setVideo_id(String video_id) {
			this.video_id = video_id;
		}
		public String getGapi_hint_params() {
			return gapi_hint_params;
		}
		public void setGapi_hint_params(String gapi_hint_params) {
			this.gapi_hint_params = gapi_hint_params;
		}
		public String getXhr_apiary_host() {
			return xhr_apiary_host;
		}
		public void setXhr_apiary_host(String xhr_apiary_host) {
			this.xhr_apiary_host = xhr_apiary_host;
		}
		public String getPpv_remarketing_url() {
			return ppv_remarketing_url;
		}
		public void setPpv_remarketing_url(String ppv_remarketing_url) {
			this.ppv_remarketing_url = ppv_remarketing_url;
		}
		public String getEventid() {
			return eventid;
		}
		public void setEventid(String eventid) {
			this.eventid = eventid;
		}
		public String getSsl() {
			return ssl;
		}
		public void setSsl(String ssl) {
			this.ssl = ssl;
		}
		public String getVm() {
			return vm;
		}
		public void setVm(String vm) {
			this.vm = vm;
		}
		public String getKeywords() {
			return keywords;
		}
		public void setKeywords(String keywords) {
			this.keywords = keywords;
		}
		public String getAllow_embed() {
			return allow_embed;
		}
		public void setAllow_embed(String allow_embed) {
			this.allow_embed = allow_embed;
		}
		public String getIdpj() {
			return idpj;
		}
		public void setIdpj(String idpj) {
			this.idpj = idpj;
		}
		public String getAccount_playback_token() {
			return account_playback_token;
		}
		public void setAccount_playback_token(String account_playback_token) {
			this.account_playback_token = account_playback_token;
		}
		public String getCr() {
			return cr;
		}
		public void setCr(String cr) {
			this.cr = cr;
		}
		public String getHost_language() {
			return host_language;
		}
		public void setHost_language(String host_language) {
			this.host_language = host_language;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public String getCsi_page_type() {
			return csi_page_type;
		}
		public void setCsi_page_type(String csi_page_type) {
			this.csi_page_type = csi_page_type;
		}
		public String getCl() {
			return cl;
		}
		public void setCl(String cl) {
			this.cl = cl;
		}
		public String getC() {
			return c;
		}
		public void setC(String c) {
			this.c = c;
		}
		public String getThumbnail_url() {
			return thumbnail_url;
		}
		public void setThumbnail_url(String thumbnail_url) {
			this.thumbnail_url = thumbnail_url;
		}
		public String getAdaptive_fmts() {
			return adaptive_fmts;
		}
		public void setAdaptive_fmts(String adaptive_fmts) {
			this.adaptive_fmts = adaptive_fmts;
		}
		public String getOf() {
			return of;
		}
		public void setOf(String of) {
			this.of = of;
		}
		public String getWatermark() {
			return watermark;
		}
		public void setWatermark(String watermark) {
			this.watermark = watermark;
		}
		public String getEnablecsi() {
			return enablecsi;
		}
		public void setEnablecsi(String enablecsi) {
			this.enablecsi = enablecsi;
		}
		public String getStoryboard_spec() {
			return storyboard_spec;
		}
		public void setStoryboard_spec(String storyboard_spec) {
			this.storyboard_spec = storyboard_spec;
		}
		public String getLoudness() {
			return loudness;
		}
		public void setLoudness(String loudness) {
			this.loudness = loudness;
		}
		public String getIs_listed() {
			return is_listed;
		}
		public void setIs_listed(String is_listed) {
			this.is_listed = is_listed;
		}
		public String getPlid() {
			return plid;
		}
		public void setPlid(String plid) {
			this.plid = plid;
		}
		public String getFexp() {
			return fexp;
		}
		public void setFexp(String fexp) {
			this.fexp = fexp;
		}
		public String getPltype() {
			return pltype;
		}
		public void setPltype(String pltype) {
			this.pltype = pltype;
		}
		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
		}
		public String getFflags() {
			return fflags;
		}
		public void setFflags(String fflags) {
			this.fflags = fflags;
		}
		public String getUcid() {
			return ucid;
		}
		public void setUcid(String ucid) {
			this.ucid = ucid;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getItct() {
			return itct;
		}
		public void setItct(String itct) {
			this.itct = itct;
		}
		public String getTmi() {
			return tmi;
		}
		public void setTmi(String tmi) {
			this.tmi = tmi;
		}
		public String getPyv_ad_channel() {
			return pyv_ad_channel;
		}
		public void setPyv_ad_channel(String pyv_ad_channel) {
			this.pyv_ad_channel = pyv_ad_channel;
		}
		public String getVideostats_playback_base_url() {
			return videostats_playback_base_url;
		}
		public void setVideostats_playback_base_url(String videostats_playback_base_url) {
			this.videostats_playback_base_url = videostats_playback_base_url;
		}
		public String getFmt_list() {
			return fmt_list;
		}
		public void setFmt_list(String fmt_list) {
			this.fmt_list = fmt_list;
		}
		public String getVss_host() {
			return vss_host;
		}
		public void setVss_host(String vss_host) {
			this.vss_host = vss_host;
		}
		public String getWatch_xlb() {
			return watch_xlb;
		}
		public void setWatch_xlb(String watch_xlb) {
			this.watch_xlb = watch_xlb;
		}
		public String getUrl_encoded_fmt_stream_map() {
			return url_encoded_fmt_stream_map;
		}
		public void setUrl_encoded_fmt_stream_map(String url_encoded_fmt_stream_map) {
			this.url_encoded_fmt_stream_map = url_encoded_fmt_stream_map;
		}
		public String getPlayer_response() {
			return player_response;
		}
		public void setPlayer_response(String player_response) {
			this.player_response = player_response;
		}
		public String getNo_get_video_log() {
			return no_get_video_log;
		}
		public void setNo_get_video_log(String no_get_video_log) {
			this.no_get_video_log = no_get_video_log;
		}
		public String getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(String timestamp) {
			this.timestamp = timestamp;
		}
		public String getVmap() {
			return vmap;
		}
		public void setVmap(String vmap) {
			this.vmap = vmap;
		}
		public String getIsmb() {
			return ismb;
		}
		public void setIsmb(String ismb) {
			this.ismb = ismb;
		}
		public String getCver() {
			return cver;
		}
		public void setCver(String cver) {
			this.cver = cver;
		}
		public String getLength_seconds() {
			return length_seconds;
		}
		public void setLength_seconds(String length_seconds) {
			this.length_seconds = length_seconds;
		}
		public String getT() {
			return t;
		}
		public void setT(String t) {
			this.t = t;
		}
		public String getRelative_loudness() {
			return relative_loudness;
		}
		public void setRelative_loudness(String relative_loudness) {
			this.relative_loudness = relative_loudness;
		}
		public String getAvg_rating() {
			return avg_rating;
		}
		public void setAvg_rating(String avg_rating) {
			this.avg_rating = avg_rating;
		}
		public String getAtc() {
			return atc;
		}
		public void setAtc(String atc) {
			this.atc = atc;
		}
		public String getPtk() {
			return ptk;
		}
		public void setPtk(String ptk) {
			this.ptk = ptk;
		}
		public String getShow_pyv_in_related() {
			return show_pyv_in_related;
		}
		public void setShow_pyv_in_related(String show_pyv_in_related) {
			this.show_pyv_in_related = show_pyv_in_related;
		}
		public String getView_count() {
			return view_count;
		}
		public void setView_count(String view_count) {
			this.view_count = view_count;
		}
		public String getApiary_host_firstparty() {
			return apiary_host_firstparty;
		}
		public void setApiary_host_firstparty(String apiary_host_firstparty) {
			this.apiary_host_firstparty = apiary_host_firstparty;
		}
		public String getSwf_player_response() {
			return swf_player_response;
		}
		public void setSwf_player_response(String swf_player_response) {
			this.swf_player_response = swf_player_response;
		}
		public String getLdpj() {
			return ldpj;
		}
		public void setLdpj(String ldpj) {
			this.ldpj = ldpj;
		}
		public String getEnablejsapi() {
			return enablejsapi;
		}
		public void setEnablejsapi(String enablejsapi) {
			this.enablejsapi = enablejsapi;
		}
		public String getLoaderUrl() {
			return loaderUrl;
		}
		public void setLoaderUrl(String loaderUrl) {
			this.loaderUrl = loaderUrl;
		}
		public String getInnertube_api_version() {
			return innertube_api_version;
		}
		public void setInnertube_api_version(String innertube_api_version) {
			this.innertube_api_version = innertube_api_version;
		}
		public String getHl() {
			return hl;
		}
		public void setHl(String hl) {
			this.hl = hl;
		}
		public String getInnertube_api_key() {
			return innertube_api_key;
		}
		public void setInnertube_api_key(String innertube_api_key) {
			this.innertube_api_key = innertube_api_key;
		}
		public String getAllow_ratings() {
			return allow_ratings;
		}
		public void setAllow_ratings(String allow_ratings) {
			this.allow_ratings = allow_ratings;
		}
		
		
	}
	
	class Params {
		private String allowfullscreen;
		private String bgcolor;
		private String allowscriptaccess;
		public String getAllowfullscreen() {
			return allowfullscreen;
		}
		public void setAllowfullscreen(String allowfullscreen) {
			this.allowfullscreen = allowfullscreen;
		}
		public String getBgcolor() {
			return bgcolor;
		}
		public void setBgcolor(String bgcolor) {
			this.bgcolor = bgcolor;
		}
		public String getAllowscriptaccess() {
			return allowscriptaccess;
		}
		public void setAllowscriptaccess(String allowscriptaccess) {
			this.allowscriptaccess = allowscriptaccess;
		}
		
	}
	
	public class Attrs {
		private String moview_player;

		public String getMoview_player() {
			return moview_player;
		}

		public void setMoview_player(String moview_player) {
			this.moview_player = moview_player;
		}
		
	}
	
}
