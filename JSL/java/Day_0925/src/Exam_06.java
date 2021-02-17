import java.util.Arrays;

//clone() : 자신을 복제 새로운 인스턴스 만들어냄 
//cloneable 인터페이스 구현해야 사용자클래스 복제ㅗ딤
public class Exam_06 {

	public static void main(String[] args) {
		int a[]= {10,20,50,40,60,50,66};
		int b[]= new int[a.length];
		
		for(int x=0;x<a.length;x++) {
			b[x]=a[x];
		}
		
		int c[]=a.clone();//사용자가 만든 클래스는 복제가 안됌
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(c));
		
		String[] str = {"aaa","bbb","ccc"};
		String[] str2=str.clone();
		System.out.println(Arrays.toString(str));
		System.out.println(Arrays.toString(str2));
	}

}
