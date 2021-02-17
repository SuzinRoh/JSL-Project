package project.controller.user;

import project.service.Action;
import project.service.user.UserLoginAction;
import project.service.user.UserLoginProAction;
import project.service.user.UserSearchId;
import project.service.user.UserSearchIdPro;
import project.service.user.UserSearchPass;
import project.service.user.UserSearchPassPro;

public class UserActionFactory {
	private static UserActionFactory instance = new UserActionFactory();
	
	private UserActionFactory() {
		
	}
	
	public static UserActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String cmd) {
		Action action = null;
		System.out.println("UserActionFactory : " + cmd);
		if(cmd.equals("user_login")) {
			action = new UserLoginAction();
		}
		else if(cmd.equals("user_login_pro")) {
			action = new UserLoginProAction();
		}
		else if(cmd.equals("user_search_id")) {
			action = new UserSearchId();
		}
		else if(cmd.equals("user_search_id_pro")) {
			action = new UserSearchIdPro();
		}
		else if(cmd.equals("user_search_pass")) {
			action = new UserSearchPass();
		}
		else if(cmd.equals("user_search_pass_pro")) {
			action = new UserSearchPassPro();
		}
		
		return action;
	}
}
