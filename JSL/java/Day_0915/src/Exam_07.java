import java.util.Scanner;

/*
 * �Է�(��ȣ, �̸�, ����,����,����)//��Ʈ�� ��Ʈ���� �迭
 * ���(��ȣ,�̸�,����,����,����,����,���,����)
 * �ο� 100���̳� 
 * ��ȣ��-99�̸� �Է�����
 */
public class Exam_07 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("�л����:");
		int bun =sc.nextInt();
		String name =sc.next();
		int kor =sc.nextInt();
		int eng =sc.nextInt();
		int mat =sc.nextInt();
		Student st1=new Student(bun,name,kor,eng,mat);
		
		st1.stuPrint();
		
		
	}

}
