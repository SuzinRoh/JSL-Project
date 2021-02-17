




public class Exam_01 {

	public static void main(String[] args) {
		int sum;//변수선언 >그냥변수
		sum=0;
		String str;//리퍼런스(참조변수)
		str="";
		
		Mouse m1;//클래스 =사용자정의형변수 리퍼런스(참조변수)
 		m1 =new Mouse();//인스턴스화 >객체생성

 		m1.mColor="black";
 		m1.mButtons=3;
 		m1.mSystem="광";
 		System.out.println("마우스 색상 "+ m1.mColor);
 		
 		m1.onClick();
 	
 		Mouse m2=new Mouse();
 		m2.mColor="white";
 		m2.onClick();
	}

}
