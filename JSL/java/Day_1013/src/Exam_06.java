import java.util.*;
//<Integar> Generic type �̶����
public class Exam_06 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();//����"Ŭ����" Ŭ���� �ٵ�������( �ڷ����� �ȉ�)
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
