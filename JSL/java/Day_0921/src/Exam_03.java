class C{
	int a=10;
	int b=20;
	
	void print() {
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
}
class CC extends C{
	int a=100;
	int c=200;
	void ccprint() {
		System.out.println("a="+super.a);
		System.out.println("a="+this.a);
		System.out.println("b="+b);
		System.out.println("c="+c);
	}
}
public class Exam_03 {

	public static void main(String[] args) {
		CC cc=new CC();
		cc.print();
		cc.ccprint();//조상클래스 a 은닉 자식클래스에서 똑같은 변수를 선언할시 조상클래스 변수는 숨어버림
	}

}
