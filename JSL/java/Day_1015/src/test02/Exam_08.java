package test02;
/* Ű����� ������̵� , �̸� ���̸� �Է¹޾� �����ä�� ����
 * set �� ���� �� ���
 * 
 * �Է����� 
 * ������ :aaa,����,30
 * 
 * 2�������
 * ���̵� �̸� ����
 * 
 * 3ó������ 
 * ������ ������̵� = "�ߺ��� ���̵� �Դϴ�" ���Է�
 * ������̵� end(��ҹ��ڱ��о���) �� ��ü��� ��� �� ���� 
 * 
 */
import java.util.*;
class Sawon{
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private int age;
	
	Sawon() {}
	Sawon(String id,String name,int age){
		this.id=id;
		this.name=name;
		this.age=age;
	}
	
	
	@Override
	public String toString() {
		return id+"\t"+name+"\t"+age;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Sawon) {
			Sawon s=(Sawon)obj;
			return s.id.equals(id);
		}else {
			return false;
		}
	}
	@Override
	public int hashCode() {
	
		return id.hashCode();
	}
}
public class Exam_08 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		Set<Sawon> sSet= new HashSet<Sawon>();
		Sawon sawon=new Sawon();
		
		
		//int cnt=0;
		
		while(true) {
			String tmp=s.nextLine();
			
			StringTokenizer st=new StringTokenizer(tmp,",");
			String id=st.nextToken();
			if (id.equalsIgnoreCase("end")) {
				break;
			}
			if(sSet!=null) {
				System.out.println("1");
				
			}
			String name=st.nextToken();
			int age=Integer.parseInt(st.nextToken());
			
			sawon=new Sawon(id,name,age);
			sSet.add(sawon);
			
			boolean b=sSet.add(sawon);
			
			
		
		
			
		}
		System.out.println("���̵�\t�̸�\t����");
		Iterator iter = sSet.iterator();
		while(iter.hasNext())
			System.out.println(iter.next()+" ");
	}

}
