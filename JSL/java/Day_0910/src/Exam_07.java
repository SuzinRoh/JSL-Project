import java.util.Scanner;

/*2차원 배열
 * score = new int[10][5]
 * 				       세로  가로
 */
public class Exam_07 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int bun[] =new int[10];
		int kor[] =new int[10];
		int eng[] =new int[10];
		int mat[] =new int[10];
		int cnt=0;
		while(true) {
			System.out.print("입력 :");
			bun[cnt] =sc.nextInt();
			if(bun[cnt]==-99) {
				break;
			}
			kor[cnt] =sc.nextInt();
			eng[cnt] =sc.nextInt();
			mat[cnt] =sc.nextInt();
		
			cnt++;
		}
		System.out.println("번호\t국어\t영어\t수학\t총점");
		
		for(int x=0;x<cnt;x++) {
			System.out.print(bun[x]+"\t"+kor[x]+"\t"+eng[x]+"\t"+mat[x]+"\t");
			System.out.println(bun[x]+kor[x]+eng[x]+mat[x]);
		}
	}
}
