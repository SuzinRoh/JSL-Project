class Sawon{
	int sabun;//멤버번수
	String name;
	int age;
	//생성자 - 객체 생성시 초기화 :클래스이름하고똑같은메소드 그걸 생성자라고함 , 디폴트생성자
	Sawon(){
		this(1);//자기자신의 생성자를 호출할때 씀
		//매개변수가 1개인 생성자를 호출
	}//디퐆트도 사용할수있음 기본값으로초기화 , 생성자메소드
	Sawon(int sabun){//사원번호만 초기값으로 쓸때사용함
		this(sabun,"이사원");
		this.sabun=sabun; //this.sabun =class 자기자신을 의미 
		//멤버변수           지역변수
	}
	Sawon(int sabun,String name){
		this(sabun,name,35);//this 는 첫줄에 한개밖에 못씀
		this.sabun=sabun;
		this.name=name;
	}
	Sawon(int s,String n,int a){
		sabun = s;
		name = n;
		age = a;
	}
	//생성자 오버로딩 (타입하고 개수가 달름) int 변수 인 두개의 생성자 메소드가 있으면 에러가남 타입과 개수가 달라야댐
	//오버로딩 있는이유 객체를 생성하는 방법이 여러가지 >다형성이있음 
	
	//사원정보 출력
	
	public void sawonPrint() {
		System.out.println(sabun+"\t"+name+"\t"+age);
	}
}
public class Exam_04 {

	public static void main(String[] args) {
		Sawon s1=new Sawon(1,"김사원",30);//생성자 매소드 d이부분>>Sawon()
		Sawon s2=new Sawon(2,"박사원",33);
		Sawon s3=new Sawon();
		s1.sawonPrint();
		s2.sawonPrint();
		s3.sawonPrint();
	}

}
