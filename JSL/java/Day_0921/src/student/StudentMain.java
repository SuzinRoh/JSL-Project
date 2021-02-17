package student;

import java.util.Scanner;

/*키보드로 번호, 이름 ,나이
 * 다음과 같이 출력하는 프로그램 작성
 * 입력: 1 이학생 29 90 89 90
 * 
 * 출력
 * 번호 이름 나이 국어 영어 수학 총점 평균
 * 1 이학생 29  80  80  80  xx   xx 
 */
public class StudentMain {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		//StuData stu=new StuData();
		int count=0;
		int	num,
			age,
			kor,
			eng,
			mat,
			tot;
		double avg;
		String name;
		
		while(true) {
			System.out.print("번호 :");
			num=sc.nextInt();
			if(num==-99)
				break;
			System.out.print("이름 :");
			name=sc.next();
			System.out.print("나이 :");
			age=sc.nextInt();
			System.out.print("국어 :");
			kor=sc.nextInt();
			System.out.print("영어 :");
			eng=sc.nextInt();
			System.out.print("수학 :");
			mat=sc.nextInt();
			
			tot=kor+eng+mat;
			avg=(tot/3);
			count++;
			
			StuData stu=new StuData(num,name,age,kor,eng,mat,tot,avg);
			System.out.println("번호\t이름\t나이\t국어\t영어\t수학\t총점\t평균");
			stu.studentPrint();
		}
		
		
	}

}
