
public class Mouse {
	//멤버변수 정의 =벰버변수,멤버필드(속성)
	String mColor;//마우스색상속성
	int mButtons;//마우스 버튼속성
	String mSystem;//마우스방식(볼,센서)
	
	//기능은 메소드
	public void onClick() {
		System.out.println(mColor + "마우스가 클릭되었습니다");
	}
	public String onDoubleClick() {
		String str= mColor+"Mouse Duble Click";
		return str;
	}
	public int onDrag() {
		int x =100;
		return x+5;
	}
	
}
