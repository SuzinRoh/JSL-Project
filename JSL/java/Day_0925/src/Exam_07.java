//finalize() ��ü�Ҹ���
class D{
	private int no;
	
	public D(int no) {
		this.no=no;
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println(no+"�� ��ü�� �Ҹ��մϴ�");
		super.finalize();
	}
}
public class Exam_07 {

	public static void main(String[] args) {
		D d1 =null;
		for(int x=0;x<50;x++) {
			d1 =new D(x);
			d1 =null;
			System.gc();
		}
		
	}

}
