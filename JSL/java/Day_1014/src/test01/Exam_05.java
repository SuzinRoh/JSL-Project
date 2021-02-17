package test01;
/* Ű���� �Է� 
 * �Է� : id,name,age(user01,�浿,25)
 * 
 * ���
 * ���̵� �̸� ����
 * user01 �浿 25
 *  .       . .
 *  ó������ 
 *  1.id �ߺ��� "�̹̻�����ξ��̵�"
 *  2.id �� end �̸� ��ü�ڷ� ����ϰ� ����
 */
import java.util.*;
class Mem{
	private String id;
	private String name;
	private int age;
	
	Mem(){}
	Mem(String id,String name,int age){
		this.id=id;
		this.name=name;
		this.age=age;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return id+"\t"+name+"\t"+age;
	}
}

public class Exam_05 {
	public static void main(String[] args) throws Exception{
		List<Mem> list =new ArrayList<Mem>();
		Scanner sc=new Scanner(System.in);
		
		int cnt=0;
		
		while(true) {
			System.out.print("���̵�,�̸�,���� :");
			String tmp=sc.nextLine();
			StringTokenizer tn=new StringTokenizer(tmp,",");
			
			String id=tn.nextToken();
			if(id.equals("end"))
				break;
			
			if(list.isEmpty()!=true) {
				Mem tm=list.get(cnt-1);
				if(tm.getId().equals(id)) {
					System.out.println("�ߺ��� ���̵� �Դϴ�");
					break;
				}
				Object ob=id;
				if(list.contains(id)) {
					System.out.println("�ߺ�");
				}
			}
			String name=tn.nextToken();
			int age=Integer.parseInt(tn.nextToken());
			list.add(new Mem(id,name,age));
			
			//System.out.println(list.get(cnt));
			
			cnt++;
		}
		System.out.println("���̵�\t�̸�\t����");
		for(int i=0;i<list.size();i++) {//==Mem m:mList
			System.out.println(list.get(i));
		}
	
	}
}
