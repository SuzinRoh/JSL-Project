
public class Student_01 {
	int number;
	String name;
	int age;
	
	Student_01(){}
	Student_01(int number, String name, int age){
		this.number=number;
		this.name=name;
		this.age=age;
		
		
	}
	
	public void stPrint() {
		System.out.print(number+"\t"+name+"\t"+age+"\t");
	}
}
