package example;
/*Ű����� �����ȣ,�̸�,���̸� �Է������޾Ƽ� Set�� ������ ����ϴ� ���α׷� �ۼ�
 * ����� �������� �������� ����ϴ� ���α׷� �ۼ�
 * �Է�����
 * ������  1101 , aaa , 23
 * 
 * �������
 * ������
 * �����ȣ �̸� ����
 */
import java.util.*;


public class Exam_03 {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		Set<Sawon> set=new HashSet<Sawon>();
		int cnt=0;
		while(true) {
			System.out.print("������ :");
			String tmp=s.nextLine();
			String[] tm=tmp.split(",");
			if(tm[0].equals("9999")) {
				break;
			}
			/*
			if(set.contains(o))
			if(set.isEmpty()==false) {
				boolean b=new Sawon(Integer.parseInt(tm[0]),tm[1],Integer.parseInt(tm[2])));
				if(b==false) {
					System.out.println("�ߺ�");
					continue;
				}
				*/
			Sawon aa=new Sawon(Integer.parseInt(tm[0]),tm[1],Integer.parseInt(tm[2]));
			if(set.contains(aa)) {
				System.out.println("�ߺ�");
				continue;	
			}
			set.add(aa);
			cnt++;
		}
		
		
		List<Sawon> list=new ArrayList<Sawon>(set);
		System.out.println("**������**");
		System.out.println("�����ȣ\t�̸�\t����");
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}

		Collections.sort(list);
		System.out.println("**��� ��ȣ��**");
		System.out.println("�����ȣ\t�̸�\t����");
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}

}
