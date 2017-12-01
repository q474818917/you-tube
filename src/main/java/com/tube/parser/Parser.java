package com.tube.parser;

import java.util.List;

import com.tube.bean.DashStream;

public interface Parser {
	
	List<DashStream> parse(String content);
	
}
