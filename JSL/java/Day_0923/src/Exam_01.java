/* �߻�Ŭ���� : �̿ϼ� ���赵
 * �������̽� :�⺻���赵 , ����
 */
interface A{
	public static final double PI=3.14;//����� ����
	//int a; �Ұ���
	public abstract void method();//�߻�޼ҵ�
	
	default void method1() {//����Ʈ �޼ҵ�
		
	}
	static void method2(int x, int y) {//�����޼ҵ�
	}
	//�������̽��� ���� �޼ҵ�� �ڵ����� �߻��̶� abstract �Ƚᵵ�� 
}	
interface AB extends A{//�������̽� ����ؼ� �������̽��� ���������
	
}
class AA implements A{//�������̽��� ������ Ŭ������ ���鶧 �������̽��� "����"

	@Override
	public void method() {
		// TODO Auto-generated method stub
		A.super.method1();
	}
	
}
public class Exam_01 {

	public static void main(String[] args) {
		A a=new AA();
		//AA aa=new AA();

	}

}
