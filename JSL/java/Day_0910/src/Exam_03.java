/*
 * �˻�
 * 1. ���� �˻�//������� �� ã��
 * 2. 2�� �˻�(����)
 */
public class Exam_03 {
	public static void main(String[] args) {
		
		int data[]= {1,5,7,3,10,23,53,40,30,2,7};
		int search=100;//7�� �˻�
		boolean b=true;
		System.out.print(search+"��\t");
		for(int x=0;x<data.length;x++) {
			if(data[x]==search) {
				System.out.print(x+"�� °\t");
				//break;
				b=false;
			}
		}
		if(b) {
			System.out.print("���� ����");
		}
		
	}//----------------------------------------------------------
}
