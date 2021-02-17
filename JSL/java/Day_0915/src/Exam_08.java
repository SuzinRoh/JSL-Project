import java.util.Scanner;

/*
 * 입력(번호, 이름, 국어,영어,수학)//인트는 인트끼리 배열
 * 출력(번호,이름,국어,영어,수학,총점,평균,판정)
 * 인원 100명이내 
 * 번호가-99이면 입력종료
 */
public class Exam_08 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		Student[] stu =new Student[100];//클래스배열
		
		
		int bun,kor,eng,mat;
		String name;
		int cnt=0;
		
		System.out.print("학생입력 :");
		while(cnt<100) {
			
			bun =sc.nextInt();
			if(bun==-99) {
				break;
			}
			
			name =sc.next();
			kor =sc.nextInt();
			eng =sc.nextInt();
			mat =sc.nextInt();
			
			stu[cnt] =new Student(bun,name,kor,eng,mat);
			
			cnt++;
			
		}
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		for(int x=0;x<cnt;x++) {
			stu[x].stuPrint();
			System.out.println();
		}
		
		
		
		
	}

}
