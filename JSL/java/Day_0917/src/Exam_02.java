import com.A;

//접근제어자
//private < 디폴트(접근제어안썻을때) < protected < public 순서대로 크기가커짐
class S{
	private int a=10;//자기자신만 접근
	int b=20;//같은 패키지내 접근
	protected int c=30;//같은 패키지내 접근이나 상속관계에 있으면 접근가능
	public int d=40;//멤버변수로 퍼블릭을 쓰지 않음
	
	public void test() {
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("c="+c);
		System.out.println("d="+d);
		
		
	}
}
public class Exam_02 {

	public static void main(String[] args) {
		S s=new S();
		//System.out.println("a="+s.a);
		System.out.println("b="+s.b);
		System.out.println("c="+s.c);
		System.out.println("d="+s.d);
		
		A a1=new A();
		
		//System.out.println("aa="+a1.aa);
		System.out.println("cc="+a1.cc);
	}

}
