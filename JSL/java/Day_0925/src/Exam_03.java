class B{
	String name;
	int age;
	B(String name, int age ){
		this.name=name;
		this.age=age;
	}
}
public class Exam_03 {

	public static void main(String[] args) {
		B b1 =new B("ȫ�浿",28);
		System.out.println(b1);
		System.out.println("�̸� :"+b1.name+"\t���� :"+b1.age);
		
		String str = new String("ȫ�浿");
		System.out.println(str);
		System.out.println("�̸� :"+ str);
	}

}
