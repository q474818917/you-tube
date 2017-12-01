package com.tube.core;

public interface StreamProgress {
	
	void start();
	
	void progress(long progressSize);
	
	void finish();
	
}
