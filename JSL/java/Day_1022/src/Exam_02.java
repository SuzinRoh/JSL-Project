
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
		b.obj=new A();//오브젝트 객체지향의 최상위 클래스, 모든객체 저장가능
	}

}
