/*
 * 상속(inheritance)
 * 
 */
class A{
		int a= 10;//멤버변수 (인스턴스)
		int b =20;
		public void print() {//멤버(인스턴스)메소드
			System.out.println("a="+a);
			System.out.println("b="+b);
		}
	}
class AA extends A{
	int c=20;
	public void data() {
		System.out.println("c="+c);
	}
}
public class Exam_01 {
	
	public static void main(String[] args) {
		A a = new A();
		a.print();
		a.a=100;
		a.b=200;
		a.print();
		
		AA aa =new AA();
		aa.print();
		aa.a=1000;
		aa.b=2000;
		aa.print();
		a.print();
	}

}
