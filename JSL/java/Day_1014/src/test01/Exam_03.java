package test01;
import java.util.*;
class Member{
	private int idx;
	private String name;
	private int age;
	
	public Member() {}
	public Member(int idx,String name,int age) {
		this.idx=idx;
		this.name=name;
		this.age=age;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
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
	public String toString() {//�ּҴ�� �� ������
		return idx+"\t"+name+"\t"+age;
	}
}
public class Exam_03 {

	public static void main(String[] args) {
		List<Member> mList =new ArrayList<Member>();
		Member m=new Member(2,"BBB",28);
		mList.add(m);
		mList.add(new Member(1,"AAA",28));//������ ��ü ���� ����Ʈ�� ����
		
		for(int x=0;x<mList.size(); x++) {
			Member mem =mList.get(x);
			System.out.println(mem.getIdx()+"\t"+mem.getName()+"\t"+mem.getAge());
		}
		System.out.println("-------------------");
		for(int x=0;x<mList.size(); x++) {
			Member mem =mList.get(x);
			System.out.println(mem);
		}
		//����
		//Collections.sort(mList);
	}

}
