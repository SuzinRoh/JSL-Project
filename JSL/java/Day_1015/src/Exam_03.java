import java.util.*;


//queue �������̽�
public class Exam_03 {

	public static void main(String[] args) {
		Queue que = new LinkedList();//ť�� �������̽��� ���� ��ü������ �Ұ�����
		
		que.offer("A");
		que.offer("B");
		que.offer("C");
		que.offer("D");
		
		System.out.println("��� �� :" +que.size());
		String str = (String)que.peek();
		System.out.println(str);
		
		while(!que.isEmpty()) {
			System.out.print(que.poll()+" ");
		}
		System.out.println();
		System.out.println("��� �� :" +que.size());
	}

}
