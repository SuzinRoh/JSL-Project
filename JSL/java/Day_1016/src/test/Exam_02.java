package test;
import java.util.*;
class A implements Comparable<A>{
	int bun;
	String name;
	A(){}
	A(int bun,String name){
		this.bun=bun;
		this.name=name;
	}
	@Override
	public String toString() {
		return bun+"\t"+name;
	}
	@Override
	public int compareTo(A o) {
		if(bun>o.bun) {//내림차순
			return -1;
		}else if(bun==o.bun) {
			return 0;
		}else {
			return 1;
		}
	}
}

public class Exam_02 {
	public static void main(String[] args) {
		Set<A> set =new HashSet<A>();
		
		set.add(new A(5,"aaa"));
		set.add(new A(3,"bbb"));
		set.add(new A(1,"ccc"));
		set.add(new A(4,"ddd"));
		set.add(new A(5,"aaa"));
		System.out.println(set);
		
		List<A> list =new ArrayList<A>(set);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
	}
}
