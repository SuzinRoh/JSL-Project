package com.jslhrd;

import java.util.Date;

import com.A;

public class B {
	private int bun;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private Date birth;
	
	
	public int getBun() {
		return bun;
	}//겟 값을꺼내올떄
	public void setBun(int bun) {
		this.bun = bun;
	}//셋 값을 번경할때
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	
	
}
