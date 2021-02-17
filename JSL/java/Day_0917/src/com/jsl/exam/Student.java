package com.jsl.exam;

public class Student {
	
	private int num;
	private String name;
	private int tot;
	private double ave;
	private int rank;
	
	public Student() {}
	public Student(int num, String name,int tot) {
		this.num=num;
		this.name=name;
		this.tot=tot;
		//Æò±Õ°è»ê
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAve() {
		return ave;
	}
	public void setAve(double ave) {
		this.ave = ave;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
}
