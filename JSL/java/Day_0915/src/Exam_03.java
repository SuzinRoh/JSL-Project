/*
 *정수 계산기만들가
 *
 */
 class Cal2{
	
	 
	 public void add(int a ,int b) {
		 System.out.println(a+"+"+b+"="+(a+b));
	 }
	 public void sub(int a ,int b) {
		 System.out.println(a+"-"+b+"="+(a-b));
	 }
	 public void mul(int a ,int b) {
		 System.out.println(a+"*"+b+"="+(a*b));
	 }
	 public void div(int a ,int b) {
		 System.out.println(a+"/"+b+"="+(a/b));
	 }
	 public void mod(int a ,int b) {
		 System.out.println(a+"%"+b+"="+(a%b));
	 }
 }
public class Exam_03 {

	public static void main(String[] args) {
		Cal2 c1 =new Cal2();
		int a =20,
				b=30;
		c1.add(10,20);
		c1.sub(50,10);
		c1.mul(a,b);
		c1.div(a,b);
		c1.mod(a,b);
	}

}
