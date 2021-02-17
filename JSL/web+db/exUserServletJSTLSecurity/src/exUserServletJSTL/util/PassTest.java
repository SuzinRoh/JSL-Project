package exUserServletJSTL.util;

public class PassTest {
	public static void main(String[] arg) {
	String pass = SHA256Util.getEncSHA256("1234");
	
	System.out.print(pass);
	}
}
