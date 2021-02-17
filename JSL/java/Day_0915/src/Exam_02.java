/*
 *정수 계산기만들가
 *
 */
 class Cal{
	 int a;
	 int b;
	 
	 public void add() {
		 System.out.println(a+"+"+b+"="+(a+b));
	 }
	 public void sub() {
		 System.out.println(a+"-"+b+"="+(a-b));
	 }
	 public void mul() {
		 System.out.println(a+"*"+b+"="+(a*b));
	 }
	 public void div() {
		 System.out.println(a+"/"+b+"="+(a/b));
	 }
	 public void mod() {
		 System.out.println(a+"%"+b+"="+(a%b));
	 }
 }
public class Exam_02 {

	public static void main(String[] args) {
		Cal c1 =new Cal();
		c1.a=100;
		c1.b=50;
		c1.add();
		c1.sub();
		c1.mul();
		c1.div();
		c1.mod();
	}

}
