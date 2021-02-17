import java.awt.Toolkit;
public class Exam_06 {

	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
	//싱글쓰레드 포문1이 끝나야 포문2가 시작
		for(int x=0;x<5;x++) {
			toolkit.beep();
			System.out.println("NO");
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
		}
		
		
		for(int x=0;x<5;x++) {
			System.out.println("ok");
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
		}
	}

}
