interface Test{
	public void method();//추상메소드 
}

public class Exam_01 {

	public static void main(String[] args) {
		Test t1 = new Test() {
			@Override
			public void method() {
				System.out.println("AAA");
			}
		};
		t1.method();
		
		//구ㅢ찬으니까 람다식으로 표현 할수있음.
		//람다식은 리턴타입 생략
		Test t2 =()->System.out.println("BBB");
		t2.method();
	}

}
