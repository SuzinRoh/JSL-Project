package view;

import java.util.Scanner;

import dao.DeleteEmp;
import dao.EmpMainUI;
import dao.InsertEmp;
import dao.PrintAllEmp;
import dao.ProgramExit;
import dao.SearchEmp;
import dao.UpdateEmp;

public class EmployeeMain {
	//１１月２４日にするプロジェクトの深化課題です。
	//二日間進めました。
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		EmpMainUI ui =new EmpMainUI();
		InsertEmp insert =new InsertEmp();
		PrintAllEmp print =new PrintAllEmp();
		SearchEmp search =new SearchEmp();
		UpdateEmp update =new UpdateEmp();
		DeleteEmp delete =new DeleteEmp();
		ProgramExit exit =new ProgramExit();
		while(true) {
			ui.getUI();
		
			int seletNum =sc.nextInt();
	
			switch(seletNum) {
				case 1:
					print.printUI();
					break;
				case 2:
					insert.insertUI();
					break;
				case 3:
					search.searchUI();
					break;
				case 4:
					update.updateUI();
					break;
				case 5:
					delete.deleteUI();
					break;
				case 6:
					exit.programExit();
					break;
			}
		}
		
		
	}
}
