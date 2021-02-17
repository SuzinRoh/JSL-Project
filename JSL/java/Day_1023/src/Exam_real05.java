interface MyFunc3{
	public int exam(int x,int y);
}
public class Exam_real05 {

	public static void main(String[] args) {
		
		MyFunc3 f3;
		f3=(x,y)->{
			return x+y;
		};
		System.out.println(f3.exam(10, 20));
		
		f3=(x,y)->x+y;
		System.out.println(f3.exam(10, 20));
		
		f3=(x,y)->sum(x,y);
		System.out.println(f3.exam(10, 20));
	}
	static int sum(int x, int y) {
		return x+y;
	}
	
	

}
