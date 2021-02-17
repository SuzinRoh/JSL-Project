class D{
	int a=10;
	int b=20;
	void print() {
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
	void print2(int a,int b) {
		
	}
}
class DD extends D{
	int a=100;
	int b=200;
	int c=300;
	@Override//어노테이션 :주석처리하는거랑 똑같은거  밑에는 오버라이딩된 부분이니까 참고하라고 씀
	void print() {//오버라이딩(재정의): 반드시 조상클래스의 메소드 이름 ,멤버가 똑같아야함
		super.print();
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("c="+c);
	}
	@Override
	void print2(int a,int c) {
		
	}
}
public class Exam_04 {

	public static void main(String[] args) {
		DD dd = new DD();
		dd.print();
		
	}

}
