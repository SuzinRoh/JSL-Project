interface Test{
	public void method();//�߻�޼ҵ� 
}

public class Exam_01 {

	public static void main(String[] args) {
		Test t1 = new Test() {
			@Override
			public void method() {
				System.out.println("AAA");
			}
		};
		t1.method();
		
		//���������ϱ� ���ٽ����� ǥ�� �Ҽ�����.
		//���ٽ��� ����Ÿ�� ����
		Test t2 =()->System.out.println("BBB");
		t2.method();
	}

}
