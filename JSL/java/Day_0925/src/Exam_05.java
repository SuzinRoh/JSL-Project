//hashCode() ��ü�� �����ϱ� ���� ������ �� "��ü"���� �ؽ��ڵ尡 ����
class C{
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	public int hashCode() {
		
		return 100;
	}
}
public class Exam_05 {

	public static void main(String[] args) {
		String str1="AAA";
		String str2="BBB";
		String str3= new String("AAA");//���ڿ��� �ؽ��ڵ� �������̵��Ǿ�����
		
		System.out.println("str1 :"+str1.hashCode());
		System.out.println("str2 :"+str2.hashCode());
		System.out.println("str3 :"+str3.hashCode());
		
		C c1 = new C();
		C c2 = new C();
		System.out.println("c1 :"+c1.hashCode());
		System.out.println("c2 :"+c2.hashCode());
	}

}
