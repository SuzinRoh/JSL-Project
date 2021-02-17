import java.util.Scanner;

/*2차원 배열
 * score = new int[10][5]
 * 				       세로  가로
 * 
 * 2차원 배열에선
 * a= 주소값  ,줄수
 * a[0]=주소값 , 칸수
 * a[][] =값
 * a[0].length
 */
public class Exam_08 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int hak[][] =new int[10][4];
		//				최대열명     번호,국,영,수
		
		int cnt=0;
		while(true) {
			System.out.print("입력 :");
			hak[cnt][0] =sc.nextInt();
			if(hak[cnt][0]==-99) {
				break;
			}
			hak[cnt][1] =sc.nextInt();
			hak[cnt][2] =sc.nextInt();
			hak[cnt][3] =sc.nextInt();
		
			cnt++;
		}
		System.out.println("번호\t국어\t영어\t수학\t총점");
		
		for(int x=0;x<cnt;x++) {
			System.out.print(hak[x][0]+"\t"+hak[x][1]+"\t"+hak[x][2]+"\t"+hak[x][3]+"\t");
			System.out.println(hak[x][1]+hak[x][2]+hak[x][3]);
		}
		System.out.println("번호\t국어\t영어\t수학\t총점");
		for(int x=0;x<cnt;x++) {
			int tot=hak[x][1]+hak[x][2]+hak[x][3];
			for(int y=0; y<hak[0].length; y++) {
			System.out.print(hak[x][y]+"\t");
			}
			System.out.print(tot);
			System.out.println();
		}
	}
}
