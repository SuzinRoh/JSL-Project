package view;

import java.util.Scanner;

import model.CustomerUI;
import model.DeleteCust;
import model.InsertCus;
import model.ModifyCust;
import model.PrintCust;
import model.SearchCust;

public class CustomerMain {

	public static void main(String[] args) {
		CustomerUI UI = new CustomerUI();
		InsertCus In = new InsertCus();
		PrintCust print =new PrintCust();
		SearchCust search =new SearchCust();
		ModifyCust modify =new ModifyCust();
		DeleteCust delete = new DeleteCust();
		Scanner sc =new Scanner(System.in);
		
		while(true) {
			
			UI.getUI();
			int selectNum = sc.nextInt();
			switch(selectNum) {
				case 1:
					print.printCust();
					break;
				case 2:
					In.insertUI();
					break;
				case 3:
					search.searchUI();
					break;
				case 4:
					modify.modifyUI();
					break;
				case 5:
					delete.deleteUI();
					break;
				case 6:
	
					System.out.println("프로그램을 종료합니다.");
					System.out.println("=================================");
					System.exit(0);
			}
		}
		
	}

}
