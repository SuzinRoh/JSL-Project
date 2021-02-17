package project.controller.company;

import project.service.Action;
import project.service.companyinsert.CompanyEmailchekAction;
import project.service.companyinsert.CompanyEmailchekProAction;
import project.service.companyinsert.CompanyIdchekAction;
import project.service.companyinsert.CompanyInsertAction;
import project.service.companyinsert.CompanyInsertProAction;

public class CompanyActionFactory {
	private CompanyActionFactory() {}
	private static CompanyActionFactory instance = new CompanyActionFactory();
	public static CompanyActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String cmd) {
		//System.out.println("actionfactory:" +cmd);
		
		Action action = null;
		if(cmd.equals("company_insert")) {
			action = new CompanyInsertAction();
		} else if(cmd.equals("company_insert_pro")) {
			action = new CompanyInsertProAction();
		} else if(cmd.equals("company_idchk")) {
			action = new CompanyIdchekAction();
		} else if(cmd.equals("company_emailchk")) {
			action = new CompanyEmailchekAction();
		} else if(cmd.equals("company_emailchk_pro")) {
			action = new CompanyEmailchekProAction();
		}
		return action;
	}
}
