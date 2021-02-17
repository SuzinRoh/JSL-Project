import java.util.*;

//collection >list set mat
//set 인터페이스 > hashset 반복자로 변환해서 뽑아옴 iterater

public class Exam_04 {

	public static void main(String[] args) {
		Set<Integer> set =new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		set.add(3);
		//중복허용안됌
		
		System.out.println(set);
		Iterator iter = set.iterator();//반복자
		//순서가없어서 와일
		while(iter.hasNext()) {//존재하면
			System.out.print(iter.next()+" ");//꺼내라
		}
		System.out.println();
		LinkedHashSet s = new LinkedHashSet();//순서유지 중복 안됌
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		s.add(3);
		System.out.println(s.size());
		//순서가잇으니까 포
		for(Object obj :s) {
			System.out.println(obj);
		}
	}

}
