package test01;

import java.util.TreeSet;

public class Exam_05 {
	public static void main(String[] args) {
		TreeSet<Person> set = new TreeSet<Person>();
		set.add(new Person("김학생", 28));
		set.add(new Person("이학생", 34));
		set.add(new Person("박학생", 26));
		set.add(new Person("김학생", 28));
		
		System.out.println(set);
	}

}
