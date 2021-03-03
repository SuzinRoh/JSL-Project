package project.controller.admin;

import project.controller.Action;
import project.service.admin.AdminCompanyConfirmAction;
import project.service.admin.AdminCompanyConfirmProAction;
import project.service.admin.AdminIndexAction;
import project.service.admin.AdminInsertAction;
import project.service.admin.AdminLoginAction;
import project.service.admin.AdminLoginProAction;
import project.service.admin.AdminLogoutAction;

public class AdminActionFactory {
	//게시판 전용 팩토리
	private static AdminActionFactory instance = new AdminActionFactory();
	
	private AdminActionFactory() {}
	
	public static AdminActionFactory getInstance() {
		return instance;
	}
	public Action getAction(String cmd) {
		Action action = null;
		System.out.println("AdminActionFactory :"  + cmd);
		if(cmd.equals("admin_login")) {
			action = new AdminLoginAction(); 
		}else if(cmd.equals("admin_login_pro")) {
			action = new AdminLoginProAction(); 
		}else if(cmd.equals("admin_insert")) {
			action = new AdminInsertAction();
		}else if(cmd.equals("admin_confirm")) {
			action = new AdminCompanyConfirmAction();
		}else if(cmd.equals("admin_confirm_pro")) {
			action = new AdminCompanyConfirmProAction();
		}else if(cmd.equals("admin_logout")) {
			action = new AdminLogoutAction();
		}else if(cmd.equals("admin_index")) {
			action = new AdminIndexAction();
		}
				
		return action;
	}
	
}
