import java.util.*;
public class Exam_01_1 {

	public static void main(String[] args) {
		List<String> list =new ArrayList<String>();
		if(list.size()==0) {
			System.out.println("����Ʈ�� ����ֽ��ϴ�");
		}
		if(list.isEmpty()) {
			System.out.println("����Ʈ�� ����ֽ��ϴ�.");
		}
		list.add("Java");//0��°
		list.add("JDBC");
		String s =list.get(0);
		
		System.out.println(list);
		List list2=new ArrayList();
		list2.add(1234);
		list2.add("java");
		int a =(int)list2.get(0);//ĳ����
		list.addAll(list2);
		System.out.println(list);
		
		boolean bool = list2.contains(1234);//���ԵǾ� ������
		System.out.println(bool);
		System.out.println(list.equals(list2));
		
		List list3 =list;
		System.out.println(list3);
		System.out.println(list.equals(list3));
		
	}

}
