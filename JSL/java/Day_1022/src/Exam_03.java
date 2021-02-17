import java.util.*;
class Person<T,M>{
	T kind;
	M model;
	
	public T getKind() {
		return kind;
	}
	public M getModel() {
		return model;
	}
	public void setKind(T kind) {
		this.kind=kind;
	}
	public void setModel(M Model) {
		this.model=model;
	}
}
class Tv{
	
}
class Car1{}
public class Exam_03 {

	public static void main(String[] args) {
		Person<Tv,String> p = new Person<Tv,String>();
		p.setKind(new Tv());
		p.setModel("»ï¼º");
		
		
		Person<Car,Tv> p2 =new Person<Car,Tv>();
	}

}
