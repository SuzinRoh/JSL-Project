
public class Exam_03 {
	static void test(Control c) {
		
	}
	public static void main(String[] args) {
		Control rc;
		rc =new Tv();
		rc.turnOn();
		rc.turnOff();
		rc.setMute(true);
		Control.changeBattery();
		
		test(new Tv());
		
		rc =new Audio();
		rc.turnOn();
		rc.turnOff();
		rc.setMute(false);
	}

}
