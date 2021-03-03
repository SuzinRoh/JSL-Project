package project.controller.company;

import project.controller.Action;
import project.service.company.CompanyCoverLetterList;
import project.service.company.CompanyCoverLetterView;
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
import project.service.company.CompanyResumeList;
import project.service.company.CompanyResumeView;
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
		}else if(cmd.equals("company_insert_pro")) {
			action = new CompanyInsertProAction();
		}else if(cmd.equals("company_idchk")) {
			action = new CompanyIdchekAction();
		}else if(cmd.equals("company_emailchk")) {
			action = new CompanyEmailchekAction();
		}else if(cmd.equals("company_emailchk_pro")) {
			action = new CompanyEmailchekProAction();
		} else if (cmd.equals("company_cover_letter_list")) {
			action = new CompanyCoverLetterList();
		} else if (cmd.equals("company_cover_letter_view")) {
			action = new CompanyCoverLetterView();
		} else if (cmd.equals("company_resume_list")) {
			action = new CompanyResumeList();
		} else if (cmd.equals("company_resume_view")) {
			action = new CompanyResumeView();
		} else if(cmd.equals("company_modify")) {	//------------------- add
			action = new CompanyModifyInfoAction();
		} else if(cmd.equals("company_modify_pro")) {
			action = new CompanyModifyInfoProAction();
        } else if(cmd.equals("company_passchk")) {
			action = new CompanyPasschkAction();
		} else if(cmd.equals("company_logout")) {
			action = new CompanyLogoutAction();
		} else if(cmd.equals("company_delete")) {
			action = new CompanyDeleteAction();
		} else if(cmd.equals("company_delete_pro")) {
			action = new CompanyDeleteProAction();
		} else if(cmd.equals("company_infomation")) {
			action = new CompanyInfomationAction();
		}
				
		return action;
	}
	
}
