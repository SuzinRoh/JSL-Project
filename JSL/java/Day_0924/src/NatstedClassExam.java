
public class NatstedClassExam {

	public static void main(String[] args) {
		Car myCar =new Car();
		
		Car.Tire tire=myCar.new Tire() ;
		tire.disp_in();
		
		Car.Engine engine=new Car.Engine();
		engine.disp_in();
	}

}
