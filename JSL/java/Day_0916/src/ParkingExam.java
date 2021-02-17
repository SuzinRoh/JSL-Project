import java.util.Scanner;

public class ParkingExam {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int cnt=0,a=0;
		
		Parking[] par=new Parking[a];
		
		System.out.println("[주차정보]");
		String carNo="";
		int parkTime=0;
		
		while(true){
			System.out.print("차량번호 :");
			carNo=s.next();
			if(carNo.equals("0000")) {
				break;
			}
			System.out.print("주차시간 :");
			parkTime=s.nextInt();
			
			par[cnt]=new Parking(carNo,parkTime);
			
			a++;
			cnt++;
			
		}
		
		System.out.println("자동차번호\t주차시간\t주차요금");
	}

}
