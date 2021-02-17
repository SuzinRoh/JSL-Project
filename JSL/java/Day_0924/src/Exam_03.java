//지역중첩클래스
//메서드가 실행될 때 클래스가 만들어짐
class Outer2{
	private int x=100;
	private int y=200;
	
	public void disp() {
		class Inner2{
			private int a=10;
			private int b=20;
			public void disp_in() {
				System.out.println("x="+x);
				System.out.println("y="+y);
				System.out.println("a="+a);
				System.out.println("b="+b);
			}
		}
		Inner2 in2=new Inner2();
		in2.disp_in();
	}
}
public class Exam_03 {

	public static void main(String[] args) {
		Outer ot=new Outer();
		ot.disp();
	}

}
