package com.jslhrd.domain;

import lombok.Data;

@Data
public class BoardVO {
	private int idx;
	private String pass;
	private String name;
	private String email;
	private String regdate;
	private String subject;
	private String contents;
	private int readcnt;
	private String ip;
}
