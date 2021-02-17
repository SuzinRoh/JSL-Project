import java.util.*;


//queue 인터페이스
public class Exam_03 {

	public static void main(String[] args) {
		Queue que = new LinkedList();//큐는 인터페이스라서 직접 객체생성이 불가능함
		
		que.offer("A");
		que.offer("B");
		que.offer("C");
		que.offer("D");
		
		System.out.println("요소 수 :" +que.size());
		String str = (String)que.peek();
		System.out.println(str);
		
		while(!que.isEmpty()) {
			System.out.print(que.poll()+" ");
		}
		System.out.println();
		System.out.println("요소 수 :" +que.size());
	}

}
