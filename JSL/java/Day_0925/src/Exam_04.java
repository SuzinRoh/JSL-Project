class BB{
	String name;
	int age;
	BB(String name, int age ){
		this.name=name;
		this.age=age;
	}
	
	@Override
	public String toString() {
		return name+"\t"+age;
	}
}
public class Exam_04 {

	public static void main(String[] args) {
		BB b1 =new BB("ȫ�浿",28);
		System.out.println(b1);
		System.out.println("�̸� :"+b1.name+"\t���� :"+b1.age);
		
	}

}
