package com.jsl.exam;

import java.util.Scanner;



/*Ű����� ��ȣ �̸� ���� ���� ���� �Է�Student ��ü�� ���� �迭�� ����
 * �Է�����
 * ���: 1 ������ 90 80 80
 * ���: 2 ������ 90 80 80
 * ��� -99 >�Է����� 
 * 
 * �������-1
 * ��ȣ �̸� ���� ��� 
 * 1 aaa xx xx
 * 
 * �������-2
 * ��ȣ �̸� ���� ��� ����
 * 1 aaa xx xx x
 */

public class StudentExam {

	public static void main(String[] args) {
		Scanner scn =new Scanner(System.in);
		
		StudentData sd=new StudentData();
		Student stu=new Student();
		int kor,
			eng,
			mat,
			num,
			tot;
		double	ave;
		String name;
		int cnt=0;
		
		System.out.println("[�л������Է�]");
		while(cnt<10) {
			System.out.print("��ȣ :");
			//stu.setNum();
			num=scn.nextInt();
			if(stu.getNum()==-99)
				break;
			System.out.print("�̸� :");
			//stu.setName(scn.next());
			name=scn.next();
			
			System.out.print("���� :");
			kor=scn.nextInt();
			System.out.print("���� :");
			eng=scn.nextInt();
			System.out.print("���� :");
			mat=scn.nextInt();
			
			sd.stuCal(kor,eng,mat);
			
			sd.student[cnt]=new Student(num,name;)
			
			cnt++;
			sd.count=cnt;
		}
		System.out.println("[�������-1]");
		System.out.println("��ȣ\t�̸�\t����\t���");
		for(int x=0;x<cnt;x++) {
			sd.stuPrint();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
