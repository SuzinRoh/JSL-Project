import java.util.Scanner;

/*
 * �Է�(��ȣ, �̸�, ����,����,����)//��Ʈ�� ��Ʈ���� �迭
 * ���(��ȣ,�̸�,����,����,����,����,���,����)
 * �ο� 100���̳� 
 * ��ȣ��-99�̸� �Է�����
 */
public class Exam_08 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		Student[] stu =new Student[100];//Ŭ�����迭
		
		
		int bun,kor,eng,mat;
		String name;
		int cnt=0;
		
		System.out.print("�л��Է� :");
		while(cnt<100) {
			
			bun =sc.nextInt();
			if(bun==-99) {
				break;
			}
			
			name =sc.next();
			kor =sc.nextInt();
			eng =sc.nextInt();
			mat =sc.nextInt();
			
			stu[cnt] =new Student(bun,name,kor,eng,mat);
			
			cnt++;
			
		}
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
		for(int x=0;x<cnt;x++) {
			stu[x].stuPrint();
			System.out.println();
		}
		
		
		
		
	}

}
