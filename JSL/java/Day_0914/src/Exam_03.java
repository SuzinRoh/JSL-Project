class Student{//내가 원하는대로 만드는 자료형 =사용자정의 자료형
	int bun=1;
	String name="김학생";
	int age=20;
	
	void print() {
		System.out.println("번호 :"+bun);
		System.out.println("이름 :"+name);
		System.out.println("나이 :"+age);
	}
}
public class Exam_03 {

	public static void main(String[] args) {
		Student stu1=new Student();
		System.out.println(stu1);
		stu1.print();
		

		Student stu2=new Student();
		System.out.println(stu2);
		stu2.bun=2;
		stu2.name="홍길동";
		stu2.age=28;
		
		stu2.print();
		
		Student stu3=stu1;
		System.out.println(stu3);//참조값 출력 (참조하고있는 위치값), 주소아님 자바는 주소없음 씨언어가 주소임
		stu3.print();
		
		}

}
