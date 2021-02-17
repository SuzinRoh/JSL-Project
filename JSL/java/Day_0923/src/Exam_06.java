class Q{
	int a=100;
	void print() {
		
	}
}
interface W{
	int b=200;
	void test();
}
interface T{
	int c=200;
	void test2();
}
class QQ extends Q implements W,T{//,자바다중상속 불가 하나를 인터페이스로 만들어서 다중상속
	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void test2() {
		// TODO Auto-generated method stub
		
	}
	
}
public class Exam_06 {

	public static void main(String[] args) {
		QQ q =new QQ();
		q.a=100;
		q.print();
		q.test();
		q.test2();

	}

}
