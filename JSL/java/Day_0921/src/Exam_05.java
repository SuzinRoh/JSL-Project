class E{
	int a=10;
	
	
	void print() {
		System.out.println("a="+a);
	}
}
final class EE extends E{
	final int c=100;
	@Override
	void print() {
		System.out.println("a="+a);
		System.out.println("c="+c);
		
	}
	//
	void eeprint() {
		System.out.println("c="+c);
		
	}
}
//class EEE extends EE{
	
//}
public class Exam_05 {

	public static void main(String[] args) {
		E e = new EE();
		e.a=100;
		e.print();
		//EE ee= new E();		
	}

}
