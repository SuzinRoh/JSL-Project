import java.util.*;
//<Integar> Generic type 이라고함
public class Exam_06 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();//전용"클래스" 클래스 다들어갈수잇음( 자료형은 안됌)
		list.add(100);
		list.add(200);
		list.add(300);
		list.add(400);
		list.add(500);
	
		int tot=0;
		for(int i=0;i<list.size();i++) {
			int score = list.get(i);
			tot+=score;
		}
		System.out.println(tot);
	}

}
