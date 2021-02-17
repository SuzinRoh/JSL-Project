import java.util.Scanner;

/*
 * 정수 배열 10개가 선언되어 있다.
 * 키보드로 1~100 사이의 정수를 입력받아서 배열에 저장 후 오름차순 출력
 * 입력자료에 0이 있으면 입력의 끝이다.
 * 
 * source :  0 0 0 0
 * sort :  0 0 0 0 
 */
public class Exam_07 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num[] = new int[10];
		int cnt=0;
		
		System.out.print("1~100까지 정수입력 :");
		while(cnt<10) {
			num[cnt] = sc.nextInt();
			if(num[cnt]==0)
				break;
			if(num[cnt]<0 || num[cnt]>100){
				System.out.println("입력오류");
				cnt--;
				continue;
			}
			cnt++;
		}
		
		System.out.print("\n"+"Source :");
		for(int x=0;x<cnt;x++)
			System.out.print(num[x]+"\t");
		
		for(int x=0; x<cnt-1; x++) {
			boolean b=true;
			for(int y=0;y<cnt-1-x;y++) {
				if(num[y]>num[y+1]) {
					int temp=num[y];
					num[y]=num[y+1];
					num[y+1]=temp;
					b=false;
				}
			}
			if(b)
				break;
		}
		
		System.out.print("\nSort :\t");
		for(int x=0;x<cnt;x++)
			System.out.print(num[x]+"\t");
		
		

	}

}
