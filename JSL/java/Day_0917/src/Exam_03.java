import com.jslhrd.B;
import com.jslhrd.java.C;

public class Exam_03 {

	public static void main(String[] args) {
		C c1=new C();
		c1.print();
		System.out.println(c1.setS());
		c1.getA(100);
		c1.print();
		
		int a=c1.setS();
		B b1=new B();
		
		int bun =b1.getBun();
		bun=100;
		b1.setBun(bun);
		System.out.println(b1.getBun());
	}

}
