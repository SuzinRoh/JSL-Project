package com.jsl.exam;
import static java.lang.System.out;

public class StudentData {
	Student stu=new Student();
	static Student[] student=new Student[10];
	static int count=10;
	
	//메소드 구현
	
	public void stuCal(int kor,int eng,int mat) {
		stu.setTot(kor+eng+mat);
		stu.setAve((stu.getTot()/3.0));
	}
	public void stuPrint() {
		out.print(stu.getNum()+"\t"+stu.getName());
		out.print(stu.getTot()+"\t"+stu.getAve());
	}
}
