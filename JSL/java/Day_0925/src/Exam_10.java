import java.util.Scanner;

/* Ű����� ���� �ܾ �Է� A-Z ���ڼ��� ���
 * �Է� : Apple
 * �Է� : seoul
 * �Է� : korea
 * ...
 * �Է� :-99 �Է�����
 * 
 *  ���
 *  A: x��
 *  B: x��
 *  ...
 *  Z: x��
 */
public class Exam_10 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] str=new String[25];
		String[] AZ= {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","W","X","Y","Z"};
		String[] az=new String[25];
		int cnt=0;
		while(cnt<str.length) {
			System.out.print("���� �ܾ� :");
		
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
