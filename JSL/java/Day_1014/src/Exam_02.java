import java.util.*;
public class Exam_02 {

	public static void main(String[] args) {
		List<String> sList =new ArrayList<String>();
		sList.add("Java");
		sList.add("Oracle");
		sList.add("Servlet");
		sList.add("Python");
		sList.add("Oracle");
		System.out.println(sList);
		
		sList.set(2, "JSP");
		System.out.println(sList);
		
		int index = sList.indexOf("Oracle");
		System.out.println(index);
		
		int index1 = sList.lastIndexOf("Oracle");
		System.out.println(index1);
		System.out.println("---");
		for(int x=0;x<sList.size();x++) {
			if(sList.get(x).equals("Oracle")) {
				System.out.print(x+"\t");
			}
		}
		System.out.println();
		List sList2 = sList.subList(1, 3);
		System.out.println(sList2);
	}

}
