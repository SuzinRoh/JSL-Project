import java.util.*;
public class Exam_07 {

	public static void main(String[] args) {
		List<String> sList = new ArrayList<String>();
		sList.add("Java");
		sList.add("DataBase");
		sList.add("Python");
		sList.add(2,"JavaScript");
		sList.add("Java");
		
		System.out.println(sList);
		/*sList.remove(0);
		System.out.println(sList);
		sList.set(1, "Oracle");
		System.out.println(sList);*/
		
		// 꺼내오기 1
		
		for(int i=0;i<sList.size();i++) {
			String str =sList.get(i);
			System.out.print(str+"\t");
		}
		System.out.println();
		
		// 꺼내오기 2 확장for 문
		for(String str : sList) { // string str = slist.get() 과 같음
			System.out.print(str+"\t");
		}
		System.out.println();
		
		//반복자
		Iterator<String> iter = sList.listIterator();
		while(iter.hasNext()) {
			String s = iter.next();
			System.out.print(s+"\t");
		}
		System.out.println();
		
		
		Collections.sort(sList);//객체정렬
		System.out.println(sList);
		System.out.println("====================================");
		List<Integer> iList =new ArrayList<Integer>();
		iList.add(89);
		iList.add(76);
		iList.add(44);
		iList.add(24);
		iList.add(98);
		System.out.println(iList);
		Collections.sort(iList);
		System.out.println(iList);//기본 오름차순 정렬
		
	}

}
