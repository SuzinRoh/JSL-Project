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
public class Exam_03_1 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int money[] = {50000,10000,5000,1000,500,100,50,10,5,1};
		int tot[]   =new int[10];
		int cnt=0;
		int workerNum[]=new int[10];	
		int workPay[]=new int[10];
		
		System.out.print("사원번호,출장비 입력 :");
		while(cnt<10) {
			workerNum[cnt] = sc.nextInt();
			if(workerNum[cnt] ==0) {
				break;
			}
			workPay[cnt]=sc.nextInt();
			cnt++;
		}
		System.out.println("사원번호\t출장비지급액\t오만\t일만\t오천\t일천\t오백\t일백\t오십\t일십\t오\t일");
		for(int x=0;x<cnt;x++) {//사원수 만큼 반복
			System.out.print(workerNum[x]+"\t"+workPay[x]+"\t\t");
			int temp=workPay[x];
			for(int y=0; y<money.length;y++) {
				int mok=temp / money[y];
				System.out.print(mok+"\t");
				tot[y]+=mok;
				temp %= money[y];
			}
			System.out.println();
		}
		System.out.print("전체 화폐 매수 :"+"\t\t");
		for(int i=0;i<10;i++) {
			System.out.print(tot[i]+"\t");
		}
		
		
	}
	
}
