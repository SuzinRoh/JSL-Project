//추상클래스 : 실체가 없는 클래스 , 미완성 클래스 
//목적: 통일 시키는게 목적 (필드,메소드)
 class AA{//> abstract 추상클래스가됨
	int a =10;
	public void print() {
		System.out.println("a="+a);
	}
}
abstract class BB {//> abstract 추상클래스가됨
		int a =10;
		public void print() {
			System.out.println("a="+a);
		}
	}
class AAA extends AA{
	
}
class BBB extends BB{
	
}
public class Exam_01 {

	public static void main(String[] args) {
		AA aa=new AA();
		aa.a=100;
		aa.print();
		//BB b=new BB(); 추상클래스는 객체 생성이 안됌
		//반드시 상속을 받아야만 쓸수있는 클래스
		BBB bbb=new BBB();
		bbb.print();
		
	}

}
