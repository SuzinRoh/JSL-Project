class D{
	int a=10;
	int b=20;
	void print() {
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
	void print2(int a,int b) {
		
	}
}
class DD extends D{
	int a=100;
	int b=200;
	int c=300;
	@Override//������̼� :�ּ�ó���ϴ°Ŷ� �Ȱ�����  �ؿ��� �������̵��� �κ��̴ϱ� �����϶�� ��
	void print() {//�������̵�(������): �ݵ�� ����Ŭ������ �޼ҵ� �̸� ,����� �Ȱ��ƾ���
		super.print();
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("c="+c);
	}
	@Override
	void print2(int a,int c) {
		
	}
}
public class Exam_04 {

	public static void main(String[] args) {
		DD dd = new DD();
		dd.print();
		
	}

}
