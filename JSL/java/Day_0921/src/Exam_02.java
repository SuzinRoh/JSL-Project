//�������� ���� ȣ��
class B{
	int a;
	int b;
	
	B(){
		System.out.println("B() ȣ��");
	}
	
	//B(){}
	B(int a, int b){
		this.a=a;
		this.b=b;
	}
}
class BB extends B{
	int c;
	
	BB(){
		
		super(1,2);
		System.out.println("BB() ȣ��");
	}
	void print() {
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("c="+c);
	}
}
public class Exam_02 {

	public static void main(String[] args) {
		BB bb=new BB();
		bb.print();
		
	}

}
