class A{
	public void test() throws Exception {
		System.out.println("aa :");
		char ch=(char)System.in.read();
//		/throw 
	}
}
public class Exam_07 {

	public static void main(String[] args) {
		//���� ���ѱ��,�̷�� throws > �޼ҵ带 ȣ���� ������� ���ѱ�� 
		
		A a=new A();
		try {
			a.test();
		}catch(Exception e) {
			//e.printStackTrace();
			System.out.println("���ϼ���?");
		}
	
		//System.in.read();
		
	}

}
