import java.util.Scanner;

/*
 * Ű����� �Է�
 * �����ȣ ��������޾�
 * �Է¿��� 
 * �Է� 1 152360
 * �Է� 2 235675
 * �Է� 3 198700
 * 
 * �Է�: 0 > �Է�����
 * 1. ����� �ִ� 10 ���̳��� �Ѵ�,
 * 
 * ��¿���
 * 
 * �����ȣ ��������޾� 	���� 	�ϸ� 	��õ 	��õ 	����	 �Ϲ�   ����   �Ͻ�  ��  ��
 * 1	 152360      3   0  	 0 	 2 	  0  	3  	1  	1 	 0 	0
 * 
 * õüȭ�� �ż�              7  3 	1	2	1	4	2 3 1 0
 */
public class Exam_03 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int money[] = {50000,10000,5000,1000,500,100,50,10,5,1};
		int tot[]   =new int[10];
		int cnt=0;
				
		
		
		while(cnt<10) {//������� �Է¹ޱ�
			System.out.print("�����ȣ :");
			int cowoker=sc.nextInt();
			if (cowoker==0) {
				break;
			}
			System.out.print("����� :");
			int pay=sc.nextInt();
			
			
			
			System.out.println("�����ȣ\t��������޾�\t����\t�ϸ�\t��õ\t��õ\t����\t�Ϲ�\t����\t�Ͻ�\t��\t��");
			System.out.print(cowoker+"\t");
			System.out.print(pay+"\t"+"\t");
			
			for(int x=0; x<money.length; x++) {
				int mok=pay/money[x];
				pay = pay%money[x];
				tot[x]+=mok;
				System.out.print(mok+"\t");
			}
			System.out.println();
			cnt++;
		}
		System.out.print("��ü ȭ�� �ż� :"+"\t"+"\t");
		for(int i=0;i<10;i++) {
			System.out.print(tot[i]+"\t");
		}
		
		
		
	}
	
}
