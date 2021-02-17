package test;
//계좌이체를 수행하는 스레드
public class Transfer extends Thread{
	SharedArea sharedArea;
	public Transfer(SharedArea area) {
		sharedArea =area;
	}
	
	public void run() {
		for(int cnt = 0; cnt <2;cnt++) {
			synchronized(sharedArea){//동기화 코드 블럭 코드 n번째부터 m 번째 줄까지 란 말
				//동기화 하려면 공유영역이 있어야함 
				//교착상태를 방지하는법 > 프로세스를 늘려준다
				sharedArea.account1.withdraw(100);
				System.out.println(sharedArea.account1.ownerName+"계좌:100만원 인출됨");
				sharedArea.account2.deposit(100);
				System.out.println(sharedArea.account2.ownerName+"계좌:100만원 입금됨");
				System.out.println();
			}
			// 메소드 동기화도 있는데 그건 메소드르 블럭화? 동기화메소드 라고함
		}
	}
}
