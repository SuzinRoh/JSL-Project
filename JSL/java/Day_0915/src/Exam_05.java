import java.util.Scanner;

/*
 * �Է�(��ȣ, �̸�, ����,����,����)
 * ���(��ȣ,�̸�,����,����,����,����,���,����)
 * �ο� 100���̳� 
 * ��ȣ��-99�̸� �Է�����
 */
public class Exam_05 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.print("��ȣ :");
			int bun =sc.nextInt();
			System.out.print("�̸� :");
			String name =sc.next();
			System.out.print("���� :");
			int kor =sc.nextInt();
			System.out.print("���� :");
			int eng =sc.nextInt();
			System.out.print("���� :");
			int mat =sc.nextInt();
			int tot=kor+eng+mat;
			double ave=tot/3.;
			String by="";
			if(ave>=90) {
				by="��";
			}else if(ave>=80) {
				by="��";
			}else if(ave>=70) {
				by="��";
			}else if(ave>=60) {
				by="��";
			}else {
				by="��";
			}
			
			System.out.println(bun+"\t"+name+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+tot+"\t"+ave+"\t"+by);
		}
	}

}
