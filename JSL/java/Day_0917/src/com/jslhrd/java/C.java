package com.jslhrd.java;

public class C {
	private int a=10;
	private int b=20;
	//��������
	// ab�� ���� �ǵ����� ���ϰ� �ϰ� �޼ҵ带 ���ؼ��� ���� �ٲ����
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
