@FunctionalInterface
interface MyFunc{
	public void method();
}

public class Exam_03 {

	public static void main(String[] args) {
		MyFunc fi = null;
		
		fi =()->{//method를 람다식으로 오버라이딩 한것
			String str="JSLHRD";
			System.out.println(str);
		};
		fi.method();
		
		fi=()->{System.out.println("Rest Method");};
		fi.method();
		
		fi=()->System.out.println("Test");
		fi.method();
		
		//오버라이딩의 목적 > 다형성...............
	}

}
