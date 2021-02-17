import java.util.Scanner;

/*
 * 키보드로 번호 이름 국어 영어 수학 점수 입력 총점 평균을 구하여 출력
 * 입력형식
 * 학생 등록 : 5 김학생 90 80 90
 * 학생등록  : 3 이학생 88 85 85
 * ..
 * 학생등록 -99 > 입력종료
 * 
 * 2 출력형식
 * 번호 이름  국어  영어  수학  총점   평균
 * 5 김학생  90   80  90  00  00.0
 * 
 * 3출력형식 (내림차순 출력)
 * 번호 이름 국어 영어 수학 총점 평균 
 */
public class Exam_07 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int cnt=0;
		int v[][]=new int[10][5];
		String name[]=new String[10];
		double ave[]=new double[10];
		System.out.println("학생등록");
		while(cnt<10) {
			System.out.print("번호 :");
			v[cnt][0]=sc.nextInt();
			if(v[cnt][0]==-99) {
				break;
			}
			System.out.print("이름 :");
			name[cnt]=sc.next();
			System.out.print("국어 :");
			v[cnt][1]=sc.nextInt();//r국
			System.out.print("영어 :");
			v[cnt][2]=sc.nextInt();//영
			System.out.print("수학 :");
			v[cnt][3]=sc.nextInt();//수
			for(int x=0;x<4;x++) {
				v[cnt][4]+=v[cnt][x];
			}
			ave[cnt]=v[cnt][4]/3.;
			cnt++;
		}
	/*	System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		for(int x=0;x<cnt;x++) {
			System.out.print(v[x][0]+"\t");//번호출력
			System.out.print(name[x]+"\t");//이름출력
			for(int y=1;y<v[x].length;y++) {
				System.out.print(v[x][y]+"\t");
			}
			System.out.print(ave[x]+"\n");//평균출력
		}*/
		//총점기준 오름차순 정렬
		for(int x=0;x<cnt;x++) {
			for(int i=x+1;i<cnt-x;i++) {
				if(v[x][0]>v[i][0]) {
					for(int j=0;j<v[i].length;j++) {
						int temp=[x][j];
					}
					
					String t=name[i];
					name[i]=name[i+1];
					name[i+1]=t;
					
					double te=ave[i];
					ave[i]=ave[i+1];
					ave[i+1]=te;
				}
			}
		}
	
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		for(int x=0;x<cnt;x++) {
			System.out.print(v[x][0]+"\t");//번호출력
			System.out.print(name[x]+"\t");//이름출력
			for(int y=1;y<v[x].length;y++) {
				System.out.print(v[x][y]+"\t");
			}
			System.out.print(ave[x]+"\n");//평균출력
		}
	}

}
