abstract class C{//클래스 안에 추상메소드가 하나라도 있으면 일반클래스로는 정의가 안됌
	int a=10;
	public void print() {
		System.out.println("a="+a);
	}
	public abstract void data();//추상메소드
}
class CC extends C{
	public void print() {
		
	}
	public void data() {//추상메소드를 오버라이딩 해줘야 추상클래스를 상속받을수있음
		
	}
}
public class Exam_02 {

	public static void main(String[] args) {
		

	}

}
