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
public class Exam_03_1 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int money[] = {50000,10000,5000,1000,500,100,50,10,5,1};
		int tot[]   =new int[10];
		int cnt=0;
		int workerNum[]=new int[10];	
		int workPay[]=new int[10];
		
		System.out.print("�����ȣ,����� �Է� :");
		while(cnt<10) {
			workerNum[cnt] = sc.nextInt();
			if(workerNum[cnt] ==0) {
				break;
			}
			workPay[cnt]=sc.nextInt();
			cnt++;
		}
		System.out.println("�����ȣ\t��������޾�\t����\t�ϸ�\t��õ\t��õ\t����\t�Ϲ�\t����\t�Ͻ�\t��\t��");
		for(int x=0;x<cnt;x++) {//����� ��ŭ �ݺ�
			System.out.print(workerNum[x]+"\t"+workPay[x]+"\t\t");
			int temp=workPay[x];
			for(int y=0; y<money.length;y++) {
				int mok=temp / money[y];
				System.out.print(mok+"\t");
				tot[y]+=mok;
				temp %= money[y];
			}
			System.out.println();
		}
		System.out.print("��ü ȭ�� �ż� :"+"\t\t");
		for(int i=0;i<10;i++) {
			System.out.print(tot[i]+"\t");
		}
		
		
	}
	
}
