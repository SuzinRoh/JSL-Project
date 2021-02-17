import java.util.Scanner;

/*
 * 키보드로 입력
 * 사원번호 출장비지급액
 * 입력예시 
 * 입력 1 152360
 * 입력 2 235675
 * 입력 3 198700
 * 
 * 입력: 0 > 입력종료
 * 1. 사원수 최대 10 명이내로 한다,
 * 
 * 출력예시
 * 
 * 사원번호 출장비지급액 	오만 	일만 	오천 	일천 	오백	 일백   오십   일십  오  일
 * 1	 152360      3   0  	 0 	 2 	  0  	3  	1  	1 	 0 	0
 * 
 * 천체화폐 매수              7  3 	1	2	1	4	2 3 1 0
 */
public class Exam_03 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int money[] = {50000,10000,5000,1000,500,100,50,10,5,1};
		int tot[]   =new int[10];
		int cnt=0;
				
		
		
		while(cnt<10) {//사원정보 입력받기
			System.out.print("사원번호 :");
			int cowoker=sc.nextInt();
			if (cowoker==0) {
				break;
			}
			System.out.print("출장비 :");
			int pay=sc.nextInt();
			
			
			
			System.out.println("사원번호\t출장비지급액\t오만\t일만\t오천\t일천\t오백\t일백\t오십\t일십\t오\t일");
			System.out.print(cowoker+"\t");
			System.out.print(pay+"\t"+"\t");
			
			for(int x=0; x<money.length; x++) {
				int mok=pay/money[x];
				pay = pay%money[x];
				tot[x]+=mok;
				System.out.print(mok+"\t");
			}
			System.out.println();
			cnt++;
		}
		System.out.print("전체 화폐 매수 :"+"\t"+"\t");
		for(int i=0;i<10;i++) {
			System.out.print(tot[i]+"\t");
		}
		
		
		
	}
	
}
