/*
 * java.lang 
 */
class A{//오브젝트는 모든클래스 자동상속
	int x =10;
	
	
}
public class Exam_01 {

	public static void main(String[] args) {
		A a1=new A();
		A a2=new A();
		System.out.println(a1);//
		System.out.println(a2);
		
		if(a1==a2) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	
		String str1="AAA";
		
		if(str1=="AAA") {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		if(a1.equals(a2)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}

	}
}
