
public class Car {
	int x=100;
	static int y=200;
	class Tire{
		int a=10;
		public void disp_in() {
			System.out.println("x="+x);
			System.out.println("y="+y);
			System.out.println("a="+a);
		}
	}
	static class Engine{
		int b=20;
		public void disp_in() {
			System.out.println("y="+y);
			System.out.println("b="+b);
		}
	}
}
