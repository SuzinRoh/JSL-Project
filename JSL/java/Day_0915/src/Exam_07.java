import java.util.Scanner;

/*
 * 입력(번호, 이름, 국어,영어,수학)//인트는 인트끼리 배열
 * 출력(번호,이름,국어,영어,수학,총점,평균,판정)
 * 인원 100명이내 
 * 번호가-99이면 입력종료
 */
public class Exam_07 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("학생등록:");
		int bun =sc.nextInt();
		String name =sc.next();
		int kor =sc.nextInt();
		int eng =sc.nextInt();
		int mat =sc.nextInt();
		Student st1=new Student(bun,name,kor,eng,mat);
		
		st1.stuPrint();
		
		
	}

}
