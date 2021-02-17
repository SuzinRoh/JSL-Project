import java.util.Scanner;

/*
 * 입력(번호, 이름, 국어,영어,수학)
 * 출력(번호,이름,국어,영어,수학,총점,평균,판정)
 * 인원 100명이내 
 * 번호가-99이면 입력종료
 */
public class Exam_05 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.print("번호 :");
			int bun =sc.nextInt();
			System.out.print("이름 :");
			String name =sc.next();
			System.out.print("국어 :");
			int kor =sc.nextInt();
			System.out.print("영어 :");
			int eng =sc.nextInt();
			System.out.print("수학 :");
			int mat =sc.nextInt();
			int tot=kor+eng+mat;
			double ave=tot/3.;
			String by="";
			if(ave>=90) {
				by="수";
			}else if(ave>=80) {
				by="우";
			}else if(ave>=70) {
				by="미";
			}else if(ave>=60) {
				by="양";
			}else {
				by="가";
			}
			
			System.out.println(bun+"\t"+name+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+tot+"\t"+ave+"\t"+by);
		}
	}

}
