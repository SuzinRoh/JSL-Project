import java.util.Scanner;

public class ParkingExam {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int cnt=0,a=0;
		
		Parking[] par=new Parking[a];
		
		System.out.println("[��������]");
		String carNo="";
		int parkTime=0;
		
		while(true){
			System.out.print("������ȣ :");
			carNo=s.next();
			if(carNo.equals("0000")) {
				break;
			}
			System.out.print("�����ð� :");
			parkTime=s.nextInt();
			
			par[cnt]=new Parking(carNo,parkTime);
			
			a++;
			cnt++;
			
		}
		
		System.out.println("�ڵ�����ȣ\t�����ð�\t�������");
	}

}
