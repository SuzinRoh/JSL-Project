package test;
//������ü�� �����ϴ� ������
public class Transfer extends Thread{
	SharedArea sharedArea;
	public Transfer(SharedArea area) {
		sharedArea =area;
	}
	
	public void run() {
		for(int cnt = 0; cnt <2;cnt++) {
			synchronized(sharedArea){//����ȭ �ڵ� �� �ڵ� n��°���� m ��° �ٱ��� �� ��
				//����ȭ �Ϸ��� ���������� �־���� 
				//�������¸� �����ϴ¹� > ���μ����� �÷��ش�
				sharedArea.account1.withdraw(100);
				System.out.println(sharedArea.account1.ownerName+"����:100���� �����");
				sharedArea.account2.deposit(100);
				System.out.println(sharedArea.account2.ownerName+"����:100���� �Աݵ�");
				System.out.println();
			}
			// �޼ҵ� ����ȭ�� �ִµ� �װ� �޼ҵ帣 ��ȭ? ����ȭ�޼ҵ� �����
		}
	}
}
