package test;
//������ü�� �ܾ� �հ踦 ���ÿ� �����ϴ� ���α׷���
public class AccountExam {

	public static void main(String[] args) {
		SharedArea area = new SharedArea();
		area.account1=new Account("111-111","���л�",2000);
		area.account2=new Account("222-222","���л�",1000);
		
		
		Transfer thread1 =new Transfer(area);
		PrintThread thread2=new PrintThread(area);
		
		
		thread1.start();
		thread2.start();
	}

}
