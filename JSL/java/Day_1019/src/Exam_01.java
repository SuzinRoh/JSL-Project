import java.util.*;
public class Exam_01 {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("myId","1234");
		map.put("asdf","1111");
		map.put("asdf","1234");
		
		Scanner s= new Scanner(System.in);
		
		while(true) {
			System.out.println("id �� password�� �Է����ּ���.");
			System.out.println("id :");
			String id =s.nextLine().trim();
			
			System.out.println("password :");
			String password = s.nextLine().trim();
			System.out.println();
			
			if(!map.containsKey(id)) {
				System.out.println("�Է��Ͻ� id�� �������� �ʽ��ϴ�.");
				continue;
			} else {
				if(!(map.get(id)).equals(password)) {
					System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				} else {
					System.out.println("id�� ��й�ȭ�� ��ġ�մϴ�.");
					break;
				}
			}
		}
		
	}

}
