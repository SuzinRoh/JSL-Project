class Parent{
	
}
class Child extends Parent{
	
}
public class Exam_07 {

	public static void main(String[] args) {
		Parent p=new Child();
		Child c =new Child();
		Child cc =(Child)p;
		if(p instanceof Parent) {//instanceof 같은 객체인지 물어보는 거
			System.out.println("==");
		}else {
			System.out.println("!=");
		}
		System.out.println("------------------------------------------------------------");
		

		if(p instanceof Child) {
			System.out.println("==");
		}else {
			System.out.println("!=");
		}
		System.out.println("------------------------------------------------------------");
		if(cc instanceof Child) {
			System.out.println("==");
		}else {
			System.out.println("!=");
		}
		System.out.println("------------------------------------------------------------");

	}

}
