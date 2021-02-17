/* 추상클래스 : 미완성 설계도
 * 인터페이스 :기본설계도 , 명세서
 */
interface A{
	public static final double PI=3.14;//상수만 가능
	//int a; 불가능
	public abstract void method();//추상메소드
	
	default void method1() {//디폴트 메소드
		
	}
	static void method2(int x, int y) {//정적메소드
	}
	//인터페이스에 들어가는 메소드는 자동으로 추상이라 abstract 안써도댐 
}	
interface AB extends A{//인터페이스 상속해서 인터페이스를 만들수있음
	
}
class AA implements A{//인터페이스를 가지고 클래스를 만들때 인터페이스를 "구현"

	@Override
	public void method() {
		// TODO Auto-generated method stub
		A.super.method1();
	}
	
}
public class Exam_01 {

	public static void main(String[] args) {
		A a=new AA();
		//AA aa=new AA();

	}

}
