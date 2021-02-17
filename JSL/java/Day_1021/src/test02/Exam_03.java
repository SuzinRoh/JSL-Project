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
	@Override//정렬
	public int compareTo(Person o) {
		return Integer.compare(age, o.age);
	}
}
//사용자 정렬은 기본자료형밖에 안댐
public class Exam_03 {

	public static void main(String[] args) {
			TreeMap<Person, Integer> map =new TreeMap<Person, Integer>();
			map.put(new Person("이학생",24),94);
			map.put(new Person("박학생",30),87);
			map.put(new Person("강학생",21),77);
			map.put(new Person("오학생",29),45);
			map.put(new Person("윤학생",25),57);
			
			
			Set<Person> set =map.keySet();
			System.out.println("for()를 이용한 키, 값 출력");
			
			for(Person key : set) {
				System.out.println(key+" : "+map.get(key));
			}
			
			System.out.println("=반복자를 이용한 출력=");
			
			Iterator iter =set.iterator();
			while(iter.hasNext()) {
				Person key = (Person)iter.next();
				System.out.println(key+":"+map.get(key));
			}
			//System.out.println("최대값 :"+map.lastEntry());
			
		
	}

}
