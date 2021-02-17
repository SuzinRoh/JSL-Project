
public class Exam_01 {

	public static void main(String[] args) {
		Car car1 =new Car();//객체생성
		
		System.out.println("제조사 :"+ car1.company);
		System.out.println("cc :"+ car1.cc);
		System.out.println("현재속도 :"+ car1.speed);
		System.out.println("시동상태 :"+ car1.starting);
		
		car1.company="현대 자동차";
		car1.cc=2000;
		car1.speed=0;
		
		System.out.println("제조사 :"+ car1.company);
		System.out.println("cc :"+ car1.cc);
		System.out.println("현재속도 :"+ car1.speed);
		System.out.println("시동상태 :"+ car1.starting);
		
		car1.startOn();
		
		System.out.println("시동상태 :"+ car1.starting);
		
		car1.speedUp();
		car1.speedUp();
		car1.speedUp();
		
		//System.out.println("현재속도 :"+ car1.speed);
		System.out.println("--------------------------");

		System.out.println(car1.speedUp2());
		System.out.println(car1.speedUp2());
		int speed =car1.speedUp2();
		System.out.println(speed);
	
		
	}

}
