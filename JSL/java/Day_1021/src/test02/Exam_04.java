package test02;
import java.util.*;
/*Ű����� ��ȣ �̸� ���� �Է¹޾� �л���ü (��ȣ�̸�) ���� treemap����
 * 
 * 1,ȫ�浿,95
 * 
 * �Է� 0 >����
 * 
 * ���Ϲ�ȣ �Է½� �̵̹�ϵȹ�ȣ�Դϴ�
 * 
 * 
 * ��� ��ȣ ���̸� ����
 * 
 * ���� ���
 * 
 */
class Student implements Comparable<Student>{
	private int number;
	private String name;
	
	Student(){}
	Student(int number,String name){
		this.number=number;
		this.name=name;
	}
	
	@Override
	public String toString() {
		
		return number+"\t"+name;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student ) {
			Student s=(Student)obj;
			return number==number;
		}else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		return number;
	}
	@Override
	public int compareTo(Student o) {
		return Integer.compare(number, o.number);
	}
}
public class Exam_04 {

	public static void main(String[] args) {
			TreeMap<Student, Integer> map = new TreeMap<Student, Integer>();
			
			Scanner s=new Scanner(System.in);
			
			while(true) {
				System.out.print("��ȣ,�̸�,���� �Է� :");
				
				String tmp=s.nextLine();
				StringTokenizer st=new StringTokenizer(tmp,",");
				
				int number = Integer.parseInt(st.nextToken());
				if (number==0)
					break;
				
				String name = st.nextToken();
				Integer score = Integer.parseInt(st.nextToken());
				
				Student stu=new Student(number,name);
				if(!map.isEmpty()) {
					if(map.containsKey(stu)) {
						System.out.println("�̹� �Էµ� ��ȣ�Դϴ�.");
						continue;
					}
				}
				map.put(stu,score);
			}
			
			System.out.println("��ȣ\t�̸�\t����");
			int tot=0;
			Set<Student> set=map.keySet();
			for(Student st : set) {
				System.out.println(st+"\t"+map.get(st));
				tot+=map.get(st);
			}
			System.out.println("���� :"+tot+" ��� :"+(tot/map.size()));
	}

}
