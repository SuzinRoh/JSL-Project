import java.util.Scanner;

/*data[] �迭�� ������ n�� ������������ ���ĵǾ� �ִ�.
 * Ű����� ã�� ���� �Է��ϸ� ��ġ�� ã�� �ǵ����ִ� �޼ҵ带 �����
 * �ߤѤ����ϴ� ���α׷��� �ۼ�
 * ã���� �ϴ� ���� ������ 1~100�̾�� �Ѵ� (�������� �Է¿��� ó��)
 * �Է¿���
 * ã�� ���Է�(1~100):77
 * ã�� �� 77�� �����ϴ�
 * ã�°� �Է�(1~100):30
 * ã�°� 30�� 4��°�� ����
 * -99�Է�
 * ���α׷��� �����մϴ�
 */
public class Exam_05 {
	static int search(int searchNum,int data[]) {//�˻��޼ҵ�
		int search=searchNum;
		int low=0,
			high=data.length-1,
			mid=0;
		
		while(low<=high) {
			mid=(low+high)/2;
			if(data[mid]==search) {
				return mid;
			}
			if(data[mid]<search) {
				low=mid+1;
			}else {
				high=mid-1;
			}
		}
		return -1;//�޼ҵ� ������ return �������� break�� ���� �ǹ� ���α׷� ���� 
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int data[]= {5,10,20,25,30,35,40,45,50,60,65,70,75,80,85,90};
		
		while(true) {
			System.out.print("ã�°� �Է�(1~100) :");
			int searchNum=s.nextInt();
			
			if(searchNum==-99) {
				System.out.println("*���α׷��� �����մϴ�.*");
				System.exit(1);
			}
			if(searchNum<1 || searchNum>100) {
				System.out.println("*�Է� �� ��������*");
				continue;
			}
			
			int a=search(searchNum,data);//search�޼ҵ� return�� a������
			
			if(a==-1) {
				System.out.println("ã�� �� "+searchNum+" �� �����ϴ�.\n");
			}else {
				System.out.println("ã�� �� "+searchNum+" �� "+a+"�� °�� �ֽ��ϴ�. \n");
			}
		}
	}

}
