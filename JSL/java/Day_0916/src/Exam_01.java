import java.util.Scanner;

/*
 * 키보드로 번호 이름 나이 입력 배열에 저장후 출력(최대 10명이내)
 * [입력형식] 
 * 등록 : 1 이학생 28
 * 등록 : 5 김학생 30
 * 등록 : 2  박학생 25
 *   .   .  .   .
 * 등록: -99 >입력종료 
 * 
 * [출력형식 -1]
 * 번호  이름   나이
 * 1  이학생   28
 * 5  김학생   30
 * 2  박학생   25
 * .   .    .
 * 
 *  [출력형식 -2] -->번호기준 오름차순
 * 번호  이름   나이
 * 1  이학생   28
 * 2  박학생   25
 * .   .    .
 */

public class Exam_01 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		Student_01[] stu=new Student_01[10];//클래스배열 배열안에 클래스가 들어감
		
		int cnt=0;
		
		int number,age;
		String name;
		
		while(cnt<10) {
			System.out.print("학생등록 :");
			
			number=sc.nextInt();
			if(number==-99)
				break;
			name=sc.next();
			age=sc.nextInt();
			
			stu[cnt]=new Student_01(number,name,age);
			// Student stu=new Student(nuber,name,age) 클래스선언후
			// stu[cnt]=stu; 넣음
			cnt++;
		}
		System.out.println("[입력자료 출력-1]");
		System.out.println("번호\t이름\t나이");
		for(int x=0;x<cnt;x++) {
			stu[x].stPrint();
			System.out.println();
			
			
		}
		
		StudentData s=new StudentData();
		s.stuSort(stu, cnt);
		System.out.println("[입력자료 출력-2]");
		System.out.println("번호\t이름\t나이");
		for(int x=0;x<cnt;x++) {
			stu[x].stPrint();
			System.out.println();
		}
		

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
