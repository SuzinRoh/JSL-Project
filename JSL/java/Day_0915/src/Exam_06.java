import java.util.Scanner;

/*
 * 입력(번호, 이름, 국어,영어,수학)//인트는 인트끼리 배열
 * 출력(번호,이름,국어,영어,수학,총점,평균,판정)
 * 인원 100명이내 
 * 번호가-99이면 입력종료
 */
public class Exam_06 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[][] hak=new int[100][5];//번호 국어 영어 수학 총점
		String name[]=new String[100];//이름
		double[] ave=new double[100];//평균
		String by[]=new String[100];//비고
		int cnt=0;
		System.out.print("학생 입력 :");
		while(cnt<100) {
			
			
			hak[cnt][0]=sc.nextInt();
			if(hak[cnt][0]==-99) {
				break;
			}
			name[cnt] =sc.next();
			hak[cnt][1] =sc.nextInt();
			hak[cnt][2] =sc.nextInt();
			hak[cnt][3] =sc.nextInt();
			hak[cnt][4]=hak[cnt][1]+hak[cnt][2]+hak[cnt][3];
			ave[cnt]=hak[cnt][4]/3.;
			
			
			if(ave[cnt]>=90) {
				by[cnt]="수";
			}else if(ave[cnt]>=80) {
				by[cnt]="우";
			}else if(ave[cnt]>=70) {
				by[cnt]="미";
			}else if(ave[cnt]>=60) {
				by[cnt]="양";
			}else {
				by[cnt]="가";
			}
			cnt++;
			
			}
		for(int x=0;x<cnt;x++) {
			System.out.println(hak[x][0]+"\t"+name[0]+"\t");
			for(int y=1;y<hak[x].length;y++) {
				System.out.print(hak[x][y]+"\t");
			}
			System.out.print(ave[x]+"\t"+by[x]);
			System.out.println();
		}
	}

}
