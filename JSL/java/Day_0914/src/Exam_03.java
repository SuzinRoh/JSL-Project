class Student{//���� ���ϴ´�� ����� �ڷ��� =��������� �ڷ���
	int bun=1;
	String name="���л�";
	int age=20;
	
	void print() {
		System.out.println("��ȣ :"+bun);
		System.out.println("�̸� :"+name);
		System.out.println("���� :"+age);
	}
}
public class Exam_03 {

	public static void main(String[] args) {
		Student stu1=new Student();
		System.out.println(stu1);
		stu1.print();
		

		Student stu2=new Student();
		System.out.println(stu2);
		stu2.bun=2;
		stu2.name="ȫ�浿";
		stu2.age=28;
		
		stu2.print();
		
		Student stu3=stu1;
		System.out.println(stu3);//������ ��� (�����ϰ��ִ� ��ġ��), �ּҾƴ� �ڹٴ� �ּҾ��� ���� �ּ���
		stu3.print();
		
		}

}
