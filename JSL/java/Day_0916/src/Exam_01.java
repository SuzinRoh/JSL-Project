import java.util.Scanner;

/*
 * Ű����� ��ȣ �̸� ���� �Է� �迭�� ������ ���(�ִ� 10���̳�)
 * [�Է�����] 
 * ��� : 1 ���л� 28
 * ��� : 5 ���л� 30
 * ��� : 2  ���л� 25
 *   .   .  .   .
 * ���: -99 >�Է����� 
 * 
 * [������� -1]
 * ��ȣ  �̸�   ����
 * 1  ���л�   28
 * 5  ���л�   30
 * 2  ���л�   25
 * .   .    .
 * 
 *  [������� -2] -->��ȣ���� ��������
 * ��ȣ  �̸�   ����
 * 1  ���л�   28
 * 2  ���л�   25
 * .   .    .
 */

public class Exam_01 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		Student_01[] stu=new Student_01[10];//Ŭ�����迭 �迭�ȿ� Ŭ������ ��
		
		int cnt=0;
		
		int number,age;
		String name;
		
		while(cnt<10) {
			System.out.print("�л���� :");
			
			number=sc.nextInt();
			if(number==-99)
				break;
			name=sc.next();
			age=sc.nextInt();
			
			stu[cnt]=new Student_01(number,name,age);
			// Student stu=new Student(nuber,name,age) Ŭ����������
			// stu[cnt]=stu; ����
			cnt++;
		}
		System.out.println("[�Է��ڷ� ���-1]");
		System.out.println("��ȣ\t�̸�\t����");
		for(int x=0;x<cnt;x++) {
			stu[x].stPrint();
			System.out.println();
			
			
		}
		
		StudentData s=new StudentData();
		s.stuSort(stu, cnt);
		System.out.println("[�Է��ڷ� ���-2]");
		System.out.println("��ȣ\t�̸�\t����");
		for(int x=0;x<cnt;x++) {
			stu[x].stPrint();
			System.out.println();
		}
		

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
