package student;

import java.util.Scanner;

/*Ű����� ��ȣ, �̸� ,����
 * ������ ���� ����ϴ� ���α׷� �ۼ�
 * �Է�: 1 ���л� 29 90 89 90
 * 
 * ���
 * ��ȣ �̸� ���� ���� ���� ���� ���� ���
 * 1 ���л� 29  80  80  80  xx   xx 
 */
public class StudentMain {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		//StuData stu=new StuData();
		int count=0;
		int	num,
			age,
			kor,
			eng,
			mat,
			tot;
		double avg;
		String name;
		
		while(true) {
			System.out.print("��ȣ :");
			num=sc.nextInt();
			if(num==-99)
				break;
			System.out.print("�̸� :");
			name=sc.next();
			System.out.print("���� :");
			age=sc.nextInt();
			System.out.print("���� :");
			kor=sc.nextInt();
			System.out.print("���� :");
			eng=sc.nextInt();
			System.out.print("���� :");
			mat=sc.nextInt();
			
			tot=kor+eng+mat;
			avg=(tot/3);
			count++;
			
			StuData stu=new StuData(num,name,age,kor,eng,mat,tot,avg);
			System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t����\t���");
			stu.studentPrint();
		}
		
		
	}

}
