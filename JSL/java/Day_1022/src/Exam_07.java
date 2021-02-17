import java.awt.Toolkit;

class ExamThread1 extends Thread{
	@Override
	public void run() {
		for(int x=0;x<5;x++) {
			System.out.println("NO");
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
		}
	}
}

class ExamThread2 extends Thread{
	@Override
	public void run() {
		for(int x=0;x<5;x++) {
			System.out.println("OK");
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
		}
	}
}
public class Exam_07 {
	public static void main(String[] args) {
		Thread th1=new ExamThread1();
		Thread th2=new ExamThread2();
		th1.start();
		th2.start();
	}

}
