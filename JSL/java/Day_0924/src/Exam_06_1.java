import java.io.IOException;

//����ó�� (Exception), Error

public class Exam_06_1 {

	public static void main(String[] args) {
		
		System.out.println("1���� �Է� :");
		
		try {//���ܰ� �� ���ɼ��� �ִºκ�
			int a = System.in.read();
		}catch(IOException e) {//���� �������� �κ� ó�� //ĳġ ���� �������� ū���� ������ �ɾ�ߴ�
			e.printStackTrace();
		}catch(Exception ee) {
			ee.printStackTrace();
		}finally {//�߻��ϴ� ���ϴ� �۾��ؾ��Ұ�� ���̳θ� ��
			
		}
	}

}
