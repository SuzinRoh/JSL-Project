package project.controller.company;

import project.controller.Action;
import project.service.company.CompanyDeleteAction;
import project.service.company.CompanyDeleteProAction;
import project.service.company.CompanyIdfoundAction;
import project.service.company.CompanyIdfoundProAction;
import project.service.company.CompanyInfomationAction;
import project.service.company.CompanyLoginAction;
import project.service.company.CompanyLoginProAction;
import project.service.company.CompanyLogoutAction;
import project.service.company.CompanyModifyInfoAction;
import project.service.company.CompanyModifyInfoProAction;
import project.service.company.CompanyPasschkAction;
import project.service.company.CompanyPassfoundAction;
import project.service.company.CompanyPassfoundProAction;
import project.service.companyinsert.CompanyEmailchekAction;
import project.service.companyinsert.CompanyEmailchekProAction;
import project.service.companyinsert.CompanyIdchekAction;
import project.service.companyinsert.CompanyInsertAction;
import project.service.companyinsert.CompanyInsertProAction;

public class CompanyActionFactory {
	//게시판 전용 팩토리
	private static CompanyActionFactory instance = new CompanyActionFactory();
	
	private CompanyActionFactory() {}
	
	public static CompanyActionFactory getInstance() {
		return instance;
	}
	public Action getAction(String cmd) {
		Action action = null;
		System.out.println("CompanyActionFactory :"  + cmd);
		if(cmd.equals("company_login")) {
			action = new CompanyLoginAction();
		}if(cmd.contentEquals("company_login_pro")) {
			action = new CompanyLoginProAction();
		}if(cmd.equals("company_idfound")) {
			action = new CompanyIdfoundAction();
		}if(cmd.equals("company_idfound_pro")) {
			action = new CompanyIdfoundProAction();
		}if(cmd.equals("company_passfound")) {
			action = new CompanyPassfoundAction();
		}if(cmd.equals("company_passfound_pro")) {
			action = new CompanyPassfoundProAction();
		}if(cmd.equals("company_insert")) {
			action = new CompanyInsertAction();
		}if(cmd.equals("company_insert_pro")) {
			action = new CompanyInsertProAction();
		}if(cmd.equals("company_idchk")) {
			action = new CompanyIdchekAction();
		}if(cmd.equals("company_emailchk")) {
			action = new CompanyEmailchekAction();
		}if(cmd.equals("company_emailchk_pro")) {
			action = new CompanyEmailchekProAction();
		}if(cmd.equals("company_modify")) {
			action = new CompanyModifyInfoAction();
		}if(cmd.equals("company_modify_pro")) {
			action = new CompanyModifyInfoProAction();
		}if(cmd.equals("company_passchk")) {
			action = new CompanyPasschkAction();
		}if(cmd.equals("company_logout")) {
			action = new CompanyLogoutAction();
		}if(cmd.equals("company_delete")) {
			action = new CompanyDeleteAction();
		}if(cmd.equals("company_delete_pro")) {
			action = new CompanyDeleteProAction();
		}if(cmd.equals("company_infomation")) {
			action = new CompanyInfomationAction();
		}
				
		return action;
	}
	
}
