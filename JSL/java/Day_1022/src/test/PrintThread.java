package test;
//���� �ܾ� ��� ������
public class PrintThread extends Thread {
	SharedArea sharedArea;
	PrintThread(SharedArea area){
		sharedArea = area;
	}
	
	public void run() {
		for(int cnt =0; cnt<3;cnt++) {
			synchronized(sharedArea){
				int sum = sharedArea.account1.balance+sharedArea.account2.balance;
				System.out.println("�����ܾ� �հ� :"+sum);
				try {
					Thread.sleep(2);
				}catch(Exception e) {}
			}
		}
	}
	
}
