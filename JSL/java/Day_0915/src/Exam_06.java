import java.util.Scanner;

/*
 * �Է�(��ȣ, �̸�, ����,����,����)//��Ʈ�� ��Ʈ���� �迭
 * ���(��ȣ,�̸�,����,����,����,����,���,����)
 * �ο� 100���̳� 
 * ��ȣ��-99�̸� �Է�����
 */
public class Exam_06 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[][] hak=new int[100][5];//��ȣ ���� ���� ���� ����
		String name[]=new String[100];//�̸�
		double[] ave=new double[100];//���
		String by[]=new String[100];//���
		int cnt=0;
		System.out.print("�л� �Է� :");
		while(cnt<100) {
			
			
			hak[cnt][0]=sc.nextInt();
			if(hak[cnt][0]==-99) {
				break;
			}
			name[cnt] =sc.next();
			hak[cnt][1] =sc.nextInt();
			hak[cnt][2] =sc.nextInt();
			hak[cnt][3] =sc.nextInt();
			hak[cnt][4]=hak[cnt][1]+hak[cnt][2]+hak[cnt][3];
			ave[cnt]=hak[cnt][4]/3.;
			
			
			if(ave[cnt]>=90) {
				by[cnt]="��";
			}else if(ave[cnt]>=80) {
				by[cnt]="��";
			}else if(ave[cnt]>=70) {
				by[cnt]="��";
			}else if(ave[cnt]>=60) {
				by[cnt]="��";
			}else {
				by[cnt]="��";
			}
			cnt++;
			
			}
		for(int x=0;x<cnt;x++) {
			System.out.println(hak[x][0]+"\t"+name[0]+"\t");
			for(int y=1;y<hak[x].length;y++) {
				System.out.print(hak[x][y]+"\t");
			}
			System.out.print(ave[x]+"\t"+by[x]);
			System.out.println();
		}
	}

}
