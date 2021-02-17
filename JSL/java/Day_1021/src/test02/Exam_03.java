package test02;
import java.util.*;
class Person implements Comparable<Person>{
	private String name;
	private int age;
	
	Person(){}
	Person(String name, int age){
		this.name=name;
		this.age=age;
	}
	@Override
	public String toString() {
		return name+":"+age;
	}
	@Override//����
	public int compareTo(Person o) {
		return Integer.compare(age, o.age);
	}
}
//����� ������ �⺻�ڷ����ۿ� �ȴ�
public class Exam_03 {

	public static void main(String[] args) {
			TreeMap<Person, Integer> map =new TreeMap<Person, Integer>();
			map.put(new Person("���л�",24),94);
			map.put(new Person("���л�",30),87);
			map.put(new Person("���л�",21),77);
			map.put(new Person("���л�",29),45);
			map.put(new Person("���л�",25),57);
			
			
			Set<Person> set =map.keySet();
			System.out.println("for()�� �̿��� Ű, �� ���");
			
			for(Person key : set) {
				System.out.println(key+" : "+map.get(key));
			}
			
			System.out.println("=�ݺ��ڸ� �̿��� ���=");
			
			Iterator iter =set.iterator();
			while(iter.hasNext()) {
				Person key = (Person)iter.next();
				System.out.println(key+":"+map.get(key));
			}
			//System.out.println("�ִ밪 :"+map.lastEntry());
			
		
	}

}
