
public interface Control {
	int MAX_VOLUME =10;//자동으로 static final 이 댐
	int MIN_VOLUME =0;
	//추상 메소드 정의
	public void turnOn();
	public void turnOff();
	public void setVolume(int volume);
	//디폴트 메소드 
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음");
		}else {
			System.out.println("무음 해제");
		}
	}
	//정적메소드
	static void changeBattery() {
		System.out.println("건전지를 교체합니다");
	}
}
