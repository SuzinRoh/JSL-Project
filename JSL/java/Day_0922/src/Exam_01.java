//�߻�Ŭ���� : ��ü�� ���� Ŭ���� , �̿ϼ� Ŭ���� 
//����: ���� ��Ű�°� ���� (�ʵ�,�޼ҵ�)
 class AA{//> abstract �߻�Ŭ��������
	int a =10;
	public void print() {
		System.out.println("a="+a);
	}
}
abstract class BB {//> abstract �߻�Ŭ��������
		int a =10;
		public void print() {
			System.out.println("a="+a);
		}
	}
class AAA extends AA{
	
}
class BBB extends BB{
	
}
public class Exam_01 {

	public static void main(String[] args) {
		AA aa=new AA();
		aa.a=100;
		aa.print();
		//BB b=new BB(); �߻�Ŭ������ ��ü ������ �ȉ�
		//�ݵ�� ����� �޾ƾ߸� �����ִ� Ŭ����
		BBB bbb=new BBB();
		bbb.print();
		
	}

}
