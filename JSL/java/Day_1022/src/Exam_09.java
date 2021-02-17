class DD implements Runnable{
	public void run() {
		for(int x=0;x<5;x++) {
			System.out.println("NO");
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
		}
	};
}
public class Exam_09 {

	public static void main(String[] args) {
		Runnable r=new DD();//인터페이스 구현은 쓰레드 객체를 만들어서 넣어줘야 동작함
		//r.strat(); error 
		Thread t1 = new Thread(r);
		t1.start();
	}

}
