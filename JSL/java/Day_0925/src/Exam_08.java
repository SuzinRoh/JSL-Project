//String
public class Exam_08 {

	public static void main(String[] args) {
		String str1="AAA";
		String str2="AAA";
		String str3= new String("AAA");//오버라이딩되어있어서 == 나오지만 사실 다른거
		
		if(str1==str2) {
			System.out.println("==");
		}else {
			System.out.println("!=");
		}
		
		if(str1==str3) {
			System.out.println("==");
		}else {
			System.out.println("!=");
		}
	}

}
