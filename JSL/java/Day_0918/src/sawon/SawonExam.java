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
		
		
		System.out.println("[��������Է�]");
		while(true) {
			System.out.print("�μ��� :");
			
			part=s.next();
			if(part.equals("end"))
				break;
			if(part.equals("END"))
				break;
			
			System.out.print("�����ȣ :");
			workerNum=s.nextInt();
			System.out.print("����̸� :");
			workerName=s.next();
			System.out.print("�޿� :");
			pay=s.nextInt();
			
			SawonData.part[count]=new Sawon(part);
			SawonData.sawon[count]=new Sawon(workerNum,workerName,pay);
			
			//sd.n++;
			count++;
			SawonData.count=count;
		}
		
		System.out.println("�μ���\t���\t�̸�\t�޿�");
		sd.sawonPrint();
		

	}

}
