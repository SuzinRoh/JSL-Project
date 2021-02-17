
public class Car {
	// 속성 -> 변수(멤버변수,멤버필드)
	String company="현대";//제조사
	int cc=2000;//자동차cc 1500cc 2000cc
	int speed=100;//속도
	boolean starting=true;//시동거는거 디폴드값 false 
	
	
	//아무것도 안주면 디폴트 초기화
	//디폴드값을 미리 줄수있음= 명시적인초기화
	
	//기능정의 -> 메소드
	//시동 걸기/끄기
	public void startOn() {
		starting =!starting;// false 가 아님 =true /true 일딴 false
	}
	//속도 올리기
	public void speedUp() {
		speed++;
		System.out.println(speed);
	}
	
	public int speedUp2() {
		speed++;
		return speed;
	}
	//속도 내리기
	public void speedDown() {
		speed--;
	}
}
