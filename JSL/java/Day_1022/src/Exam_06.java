import java.awt.Toolkit;
public class Exam_06 {

	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
	//�̱۾����� ����1�� ������ ����2�� ����
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
