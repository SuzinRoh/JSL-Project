package com.jslhrd.domain;

import lombok.Data;

@Data
public class PageVO {
	//페이지 처리
	private int startpage;
	private int endpage;
	
	//검색용
	private String search;
	private String key;
}