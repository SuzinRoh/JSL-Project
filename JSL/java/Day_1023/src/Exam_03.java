@FunctionalInterface
interface MyFunc{
	public void method();
}

public class Exam_03 {

	public static void main(String[] args) {
		MyFunc fi = null;
		
		fi =()->{//method�� ���ٽ����� �������̵� �Ѱ�
			String str="JSLHRD";
			System.out.println(str);
		};
		fi.method();
		
		fi=()->{System.out.println("Rest Method");};
		fi.method();
		
		fi=()->System.out.println("Test");
		fi.method();
		
		//�������̵��� ���� > ������...............
	}

}
