import com.A;

//����������
//private < ����Ʈ(��������ț�����) < protected < public ������� ũ�ⰡĿ��
class S{
	private int a=10;//�ڱ��ڽŸ� ����
	int b=20;//���� ��Ű���� ����
	protected int c=30;//���� ��Ű���� �����̳� ��Ӱ��迡 ������ ���ٰ���
	public int d=40;//��������� �ۺ��� ���� ����
	
	public void test() {
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("c="+c);
		System.out.println("d="+d);
		
		
	}
}
public class Exam_02 {

	public static void main(String[] args) {
		S s=new S();
		//System.out.println("a="+s.a);
		System.out.println("b="+s.b);
		System.out.println("c="+s.c);
		System.out.println("d="+s.d);
		
		A a1=new A();
		
		//System.out.println("aa="+a1.aa);
		System.out.println("cc="+a1.cc);
	}

}
