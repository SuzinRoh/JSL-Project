/*
 * Ű����� �ݾ��� �Է� ȭ������� �ż� ���
 */
public class Exam_02 {

	public static void main(String[] args) {
		int money[]= {50000,10000,5000,1000,500,100,50,10,5,1};
					 // 0��°
		int pay=178958;//Ű�����Է�
		
		for(int x=0; x<money.length; x++) {
			System.out.print(money[x]+":");
			int mok=pay/money[x];
			System.out.print(mok+"\n");
			pay=pay%money[x];
			
		}
	}

}
