//String
public class Exam_08 {

	public static void main(String[] args) {
		String str1="AAA";
		String str2="AAA";
		String str3= new String("AAA");//�������̵��Ǿ��־ == �������� ��� �ٸ���
		
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
