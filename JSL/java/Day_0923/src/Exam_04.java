interface C{
	void print();
}
class CC implements C{

	@Override
	public void print() {
		System.out.println("c");
		
	}
	
}

public class Exam_04 {

	public static void main(String[] args) {
		C c=new CC();
		c.print();
		//�͸� ���� ��ü
		C cc=new C() {
			@Override
			public void print() {
				System.out.println("�͸� ���� ��ü");
			}
		};
		cc.print();
	}

}
