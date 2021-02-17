class A{
	public void test() throws Exception {
		System.out.println("aa :");
		char ch=(char)System.in.read();
//		/throw 
	}
}
public class Exam_07 {

	public static void main(String[] args) {
		//예외 떠넘기기,미루기 throws > 메소드를 호출한 사람한테 떠넘기기 
		
		A a=new A();
		try {
			a.test();
		}catch(Exception e) {
			//e.printStackTrace();
			System.out.println("잘하세요?");
		}
	
		//System.in.read();
		
	}

}
