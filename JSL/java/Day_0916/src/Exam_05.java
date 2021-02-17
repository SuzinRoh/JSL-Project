//싱글톤
//디폴트생성자 생략됨
class DD{
	int x=100;
	
	private DD() {}//외부사람들은 DD d1=new DD() 못씀
	
	private static DD instance =new DD();//dd객체생성
	             //v 리턴타입 class 리턴
	public static DD getInstance(){
		
		return instance;
		//클래스 객체 instance를 리턴 
	}
}
public class Exam_05 {
	public static void main(String[] args) {
		/*
		DD d1=new DD();//생성자 만듬
		DD d2=new DD();
		*/
		DD d1=DD.getInstance();//메소드 호출 > 메소드 안에있는 return 값 instance 객체를 가져옴
		DD d2=DD.getInstance();
		if(d1==d2) {
			System.out.println("==");
		}else {
			System.out.println("!=");
		}//싱글톤
	
		
		
	}

}
