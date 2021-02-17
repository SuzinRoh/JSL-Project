import java.util.Scanner;

/* 키보드로 영문 단어를 입력 A-Z 글자수를 출력
 * 입력 : Apple
 * 입력 : seoul
 * 입력 : korea
 * ...
 * 입력 :-99 입력종료
 * 
 *  출력
 *  A: x번
 *  B: x번
 *  ...
 *  Z: x번
 */
public class Exam_10 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] str=new String[25];
		String[] AZ= {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","W","X","Y","Z"};
		String[] az=new String[25];
		int cnt=0;
		while(cnt<str.length) {
			System.out.print("영문 단어 :");
		
			str[cnt]=sc.next().toString();
			if(str[cnt].equals("-99"))
				break;
			cnt++;
		}
		
		for(int x=0;x<cnt;x++) {
			System.out.println(AZ[x]+" :"+str[x].length());
		}
		
		
		
		
	}

}
