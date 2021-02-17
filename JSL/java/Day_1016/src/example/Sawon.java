package example;

public class Sawon implements Comparable<Sawon> {
	private int sabun;
	private String name;
	private int age;
	
	Sawon() {}
	Sawon(int sabun){
		this.sabun=sabun;
	}
	Sawon(int sabun, String name,int age){
		this.sabun=sabun;
		this.name=name;
		this.age=age;
	}
	@Override
	public String toString() {
		return sabun+"\t"+name+"\t"+age;
	}
	
	
	@Override
	public int compareTo(Sawon i) {
		if(sabun<i.sabun) {
			return -1;
		}else if(sabun==i.sabun) {
			return 0;
		}else {
			return 1;
		}
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Sawon) {
			Sawon s=(Sawon)obj;
			return sabun==sabun;
		}else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		return sabun;
	}
	
}
