import java.util.*;

//collection >list set mat
//set �������̽� > hashset �ݺ��ڷ� ��ȯ�ؼ� �̾ƿ� iterater

public class Exam_04 {

	public static void main(String[] args) {
		Set<Integer> set =new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		set.add(3);
		//�ߺ����ȉ�
		
		System.out.println(set);
		Iterator iter = set.iterator();//�ݺ���
		//��������� ����
		while(iter.hasNext()) {//�����ϸ�
			System.out.print(iter.next()+" ");//������
		}
		System.out.println();
		LinkedHashSet s = new LinkedHashSet();//�������� �ߺ� �ȉ�
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		s.add(3);
		System.out.println(s.size());
		//�����������ϱ� ��
		for(Object obj :s) {
			System.out.println(obj);
		}
	}

}
