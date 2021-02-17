package com.jsl.exam;

import java.util.Scanner;



/*키보드로 번호 이름 국어 영어 수학 입력Student 객체를 생성 배열에 저장
 * 입력형식
 * 등록: 1 ㅁㅁㅁ 90 80 80
 * 등록: 2 ㅁㅁㅁ 90 80 80
 * 등록 -99 >입력종료 
 * 
 * 출력형식-1
 * 번호 이름 총점 평균 
 * 1 aaa xx xx
 * 
 * 출력형식-2
 * 번호 이름 총점 평균 석차
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
		
		System.out.println("[학생정보입력]");
		while(cnt<10) {
			System.out.print("번호 :");
			//stu.setNum();
			num=scn.nextInt();
			if(stu.getNum()==-99)
				break;
			System.out.print("이름 :");
			//stu.setName(scn.next());
			name=scn.next();
			
			System.out.print("국어 :");
			kor=scn.nextInt();
			System.out.print("영어 :");
			eng=scn.nextInt();
			System.out.print("수학 :");
			mat=scn.nextInt();
			
			sd.stuCal(kor,eng,mat);
			
			sd.student[cnt]=new Student(num,name;)
			
			cnt++;
			sd.count=cnt;
		}
		System.out.println("[출력형식-1]");
		System.out.println("번호\t이름\t총점\t평균");
		for(int x=0;x<cnt;x++) {
			sd.stuPrint();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
