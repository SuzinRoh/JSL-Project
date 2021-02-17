import java.util.ArrayList;
import java.util.List;

//List > ArryList,	Vector(동기화> 멀티쓰레드지원),LinkedList(비상연락망)
public class Exam_05 {

	public static void main(String[] args) {
		
		List list = new ArrayList();//기본공강 16개
		
		list.add(100);
		list.add("java");
		list.add(3.14);
		list.add('A');
		
		System.out.println("List :"+ list);
		
		list.add(1,"김자바");
		System.out.println("List :"+ list);
		
		System.out.println("List0 :"+list.get(0));
		
		for(int i=0;i<list.size();i++) {
			Object str=list.get(i);
			System.out.print(str+"\t");
		}
		
	
	
	}

}
