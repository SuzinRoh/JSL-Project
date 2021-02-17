package test01;

import java.util.*;


class Member{
	private String name;
	private int age;
	
	public Member() {}
	
	public Member(String name,int age) {
		this.name=name;
		this.age=age;
	}
	
	@Override
	public String toString() {
		return name+"\t"+age;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member m=(Member)obj;
			return m.name.equals(name) && m.age==age;
		}else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		return name.hashCode()+age;//문자는해시코드 있찌만 기본자료형은 해쉬코드가 업ㅅ음
	}
}
public class Exam_07 {
	public static void main(String[] args) {
		Set<Member> mSet = new HashSet<Member>();
		Member m =new Member("AAA",23);
		boolean b =mSet.add(m);
		System.out.println(b);
		System.out.println(mSet);
		//false 가 나오면 중복 
		mSet.add(new Member("BBB",30));
		System.out.println(b);
		System.out.println(mSet);
		
		mSet.add(new Member("CCC",26));
		System.out.println(b);
		System.out.println(mSet);
		
		mSet.add(new Member("AAA",23));
		System.out.println(b);
		System.out.println(mSet);
		System.out.println("??");
		
	}

}
