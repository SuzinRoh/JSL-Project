
class Box<T>{
	T obj;
	Box(T obj){
		this.obj=obj;
	}
}
class A{
	
}
public class Exam_02 {

	public static void main(String[] args) {
		Box b = new Box(new String());
		b.obj=new A();//������Ʈ ��ü������ �ֻ��� Ŭ����, ��簴ü ���尡��
	}

}
