package com.jslhrd.java;

public class C {
	private int a=10;
	private int b=20;
	//정보은닉
	// ab를 직접 건들이지 못하게 하고 메소드를 통해서만 값을 바뀌게함
	public void getA(int a) {
		this.a=a;
	}//get 
	public void getB(int b) {
		this.b=b;
	}
	public void print() {
		System.out.println("a ="+a);
		System.out.println("b ="+b);
	}
	public int setS() {
		return a;
	}//set 
}
