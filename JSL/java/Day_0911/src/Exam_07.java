import java.util.Scanner;

/*
 * Ű����� ��ȣ �̸� ���� ���� ���� ���� �Է� ���� ����� ���Ͽ� ���
 * �Է�����
 * �л� ��� : 5 ���л� 90 80 90
 * �л����  : 3 ���л� 88 85 85
 * ..
 * �л���� -99 > �Է�����
 * 
 * 2 �������
 * ��ȣ �̸�  ����  ����  ����  ����   ���
 * 5 ���л�  90   80  90  00  00.0
 * 
 * 3������� (�������� ���)
 * ��ȣ �̸� ���� ���� ���� ���� ��� 
 */
public class Exam_07 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int cnt=0;
		int v[][]=new int[10][5];
		String name[]=new String[10];
		double ave[]=new double[10];
		System.out.println("�л����");
		while(cnt<10) {
			System.out.print("��ȣ :");
			v[cnt][0]=sc.nextInt();
			if(v[cnt][0]==-99) {
				break;
			}
			System.out.print("�̸� :");
			name[cnt]=sc.next();
			System.out.print("���� :");
			v[cnt][1]=sc.nextInt();//r��
			System.out.print("���� :");
			v[cnt][2]=sc.nextInt();//��
			System.out.print("���� :");
			v[cnt][3]=sc.nextInt();//��
			for(int x=0;x<4;x++) {
				v[cnt][4]+=v[cnt][x];
			}
			ave[cnt]=v[cnt][4]/3.;
			cnt++;
		}
	/*	System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
		for(int x=0;x<cnt;x++) {
			System.out.print(v[x][0]+"\t");//��ȣ���
			System.out.print(name[x]+"\t");//�̸����
			for(int y=1;y<v[x].length;y++) {
				System.out.print(v[x][y]+"\t");
			}
			System.out.print(ave[x]+"\n");//������
		}*/
		//�������� �������� ����
		for(int x=0;x<cnt;x++) {
			for(int i=x+1;i<cnt-x;i++) {
				if(v[x][0]>v[i][0]) {
					for(int j=0;j<v[i].length;j++) {
						int temp=[x][j];
					}
					
					String t=name[i];
					name[i]=name[i+1];
					name[i+1]=t;
					
					double te=ave[i];
					ave[i]=ave[i+1];
					ave[i+1]=te;
				}
			}
		}
	
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
		for(int x=0;x<cnt;x++) {
			System.out.print(v[x][0]+"\t");//��ȣ���
			System.out.print(name[x]+"\t");//�̸����
			for(int y=1;y<v[x].length;y++) {
				System.out.print(v[x][y]+"\t");
			}
			System.out.print(ave[x]+"\n");//������
		}
	}

}
