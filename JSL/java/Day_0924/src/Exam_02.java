//2.���� ��øŬ����
class Outer1{
	private int x=100;
	private static int y=200;
	public void disp() {
		System.out.println("x="+x);
		System.out.println("y="+y);
	}
	static class Inner1{
		private int a=10;
		private static int b=20;
		static int c=20;
		public void disp_in() {
			//System.out.println("x="+x); ���� ��øŬ������ ����Ʈ ����� ����
			System.out.println("y="+y);
			System.out.println("a="+a);
			System.out.println("b="+b);
			System.out.println("c="+c);
		}
	}
}
public class Exam_02 {

	public static void main(String[] args) {
		//������øŬ����
		Outer1 ot = new Outer1();
		Outer1.Inner1 oi=new Outer1.Inner1();
		oi.disp_in();
		System.out.println("----------------");
		System.out.println("c="+Outer1.Inner1.c);
	}

}
