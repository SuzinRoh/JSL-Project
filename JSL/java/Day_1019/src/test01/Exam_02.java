package test01;
import java.util.*;
class Student{
	private int sno;
	private String sname;
	
	public Student() {}
	public Student(int sno,String sname) {
		this.sno=sno;
		this.sname=sname;
	}
	@Override
	public String toString() {
		return sno+"\t"+sname;
	}
	@Override
	public  boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student s=(Student)obj;
			return sno==sno && s.sname.equals(sname);
		}else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		return sno;
	}
}
public class Exam_02 {

	public static void main(String[] args) {
		Map<Student,Integer> sMap = new HashMap<Student,Integer>();
		sMap.put(new Student(1,"ȫ�浿"), 100);
		sMap.put(new Student(5,"��浿"), 88);
		sMap.put(new Student(3,"�ڱ浿"), 70);
		sMap.put(new Student(2,"��浿"), 90);
		sMap.put(new Student(9,"���浿"), 95);
		sMap.put(new Student(7,"Ȳ�浿"), 70);
		sMap.put(new Student(1,"ȫ�浿"), 100);
		//Ű����� ��ȣ , �̸��� �Է� Student ��ü�� ����
		//map �� ����� ��ü�� ã�Ƽ� ��� ã�� ��ü�� ������� "��ϵ� �ڷ� ����"
		Scanner s= new Scanner (System.in);
		
		while(true) {
			System.out.print("ã�� ����� ��ȣ,�̸� :");
			String tmp=s.nextLine().trim();
			
			StringTokenizer st=new StringTokenizer(tmp,",");
			int num= Integer.parseInt(st.nextToken());
			String name= st.nextToken();
			
			Student tmpStu =new Student(num,name);

			if(sMap.containsKey(tmpStu)) {
				for(Object o: sMap.keySet()) { 
					if(sMap.get(o).equals(sMap.get(tmpStu))) {
							System.out.print(o+"\t");
							System.out.print(sMap.get(o));
							System.out.println();
					} 
				} 
				break;
			}else {
				System.out.println("������ ����");
				continue;
			}
			
		}
		System.out.println();
		//2. ���� �հ踦 ���Ͽ� ���
		
		int tot=0;
		
		Iterator it = sMap.keySet().iterator();
		Collection Values = sMap.values();
		
		it=Values.iterator();
		
        while (it.hasNext()) {
            Integer a =(Integer) it.next();
            tot+=a.intValue();
        }
        System.out.println("���� :"+tot);
		
		//3. ������ �ִ밪, �ּҰ��� ã�Ƽ� ���
        System.out.println("���� :"+tot);
		System.out.println("��� :"+(float)tot/sMap.size());
		System.out.println("�ְ����� :"+Collections.max(Values));
		System.out.println("�ּ����� :"+Collections.min(Values));
	}
}
