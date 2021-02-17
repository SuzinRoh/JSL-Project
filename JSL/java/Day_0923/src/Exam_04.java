interface C{
	void print();
}
class CC implements C{

	@Override
	public void print() {
		System.out.println("c");
		
	}
	
}

public class Exam_04 {

	public static void main(String[] args) {
		C c=new CC();
		c.print();
		//劳疙 备泅 按眉
		C cc=new C() {
			@Override
			public void print() {
				System.out.println("劳疙 备泅 按眉");
			}
		};
		cc.print();
	}

}
