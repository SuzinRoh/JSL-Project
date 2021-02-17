/*
 * java.lang 
 */
class AA{//오브젝트는 모든클래스 자동상속
	int x =10;
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof AA) {
			AA a=(AA)obj;
			return x==a.x;
		}else {
			return false;
		}
	}
	
}
public class Exam_02 {

	public static void main(String[] args) {
		AA a1=new AA();
		AA a2=new AA();
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
