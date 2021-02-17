package test01;

import java.util.*;

class Student{
	private int bun;
	private String name;
	private int score;
	
	Student(){}
	Student(int bun,String name, int score){
		this.bun=bun;
		this.name=name;
		this.score=score;
	}
	
	public int getBun() {
		return bun;
	}
	public void setBun(int bun) {
		this.bun = bun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return bun+"\t"+name+"\t"+score;
	}
	public void sort(List<Student> sList) {
		
	}
}
public class Exam_04 {

	public static void main(String[] args) {
		List<Student> sList =new ArrayList<Student>();
		sList.add(new Student(1,"aaa",81));
		sList.add(new Student(5,"bbb",42));
		sList.add(new Student(3,"ccc",66));
		sList.add(new Student(7,"ddd",18));
		sList.add(new Student(2,"eee",77));
		
		
		//1.��ü�ڷ� ���
		System.out.println("��ȣ\t�̸�\t����");
		for(int i=0;i<sList.size();i++) {
			
			System.out.println(sList.get(i));
		}
		
		//��ȣ���� �������� ���
		
		for(int x=0;x<sList.size()-1;x++) {
			for(int y=x+1;y<sList.size();y++) {
				Student st = sList.get(x);
				Student st2= sList.get(y);
				if(st.getBun()>st2.getBun()) {
					/*
					Student tmp=sList.get(x);
					sList.set(x,st2);
					sList.set(y, tmp);
					*/
					sList.set(x, st2);
					sList.set(y, st);
				}
			}
			
		}//Ŭ������ �������� �޼ҵ�� �����ص���
		//�޼ҵ�� �������Ÿ� List ��ä�� �޾ƾ��� ^Student.sort();
		
		
		System.out.println("-----------");
		System.out.println("��ȣ\t�̸�\t����");
		for(int i=0;i<sList.size();i++) {
			Student st = sList.get(i);
			System.out.println(st);
		}
	}

}
