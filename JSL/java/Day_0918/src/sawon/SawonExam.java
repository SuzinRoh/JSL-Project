package sawon;

import java.util.Scanner;

public class SawonExam {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		SawonData sd=new SawonData(); 
		Sawon sw=new Sawon();
		int count=0;
		
		
		String part="";
		int workerNum=0;
		String workerName="";
		int pay=0;
		
		
		System.out.println("[사원정보입력]");
		while(true) {
			System.out.print("부서명 :");
			
			part=s.next();
			if(part.equals("end"))
				break;
			if(part.equals("END"))
				break;
			
			System.out.print("사원번호 :");
			workerNum=s.nextInt();
			System.out.print("사원이름 :");
			workerName=s.next();
			System.out.print("급여 :");
			pay=s.nextInt();
			
			SawonData.part[count]=new Sawon(part);
			SawonData.sawon[count]=new Sawon(workerNum,workerName,pay);
			
			//sd.n++;
			count++;
			SawonData.count=count;
		}
		
		System.out.println("부서명\t사번\t이름\t급여");
		sd.sawonPrint();
		

	}

}
