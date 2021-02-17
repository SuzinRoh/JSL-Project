//정적 멤버(static)
class BB{
	static int a;
	static {// 정적초기화블럭
		a=100;
	}
	//static int b=20;//변수앞에 스태틱을 붙이면 정적멤버가 됨
	
	public void test() {
		System.out.println("a="+a);
	}
}
class SS{
	
}
public class Exam_04 {

	public static void main(String[] args) {
		//BB.a=1000;
		
		BB b1=new BB();
		b1.test();
		BB b2 =new BB();
		b2.test();
		
		b1.a=0;
		b1.test();
		b2.test();
		
		
	}

}
