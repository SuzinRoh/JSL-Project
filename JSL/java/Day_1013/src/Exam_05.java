import java.util.ArrayList;
import java.util.List;

//List > ArryList,	Vector(����ȭ> ��Ƽ����������),LinkedList(��󿬶���)
public class Exam_05 {

	public static void main(String[] args) {
		
		List list = new ArrayList();//�⺻���� 16��
		
		list.add(100);
		list.add("java");
		list.add(3.14);
		list.add('A');
		
		System.out.println("List :"+ list);
		
		list.add(1,"���ڹ�");
		System.out.println("List :"+ list);
		
		System.out.println("List0 :"+list.get(0));
		
		for(int i=0;i<list.size();i++) {
			Object str=list.get(i);
			System.out.print(str+"\t");
		}
		
	
	
	}

}
