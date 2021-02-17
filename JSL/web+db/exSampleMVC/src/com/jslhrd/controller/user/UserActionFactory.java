package com.jslhrd.controller.user;

import com.jslhrd.service.Action;
import com.jslhrd.service.user.UserIdcheckAction;
import com.jslhrd.service.user.UserInsertAction;
import com.jslhrd.service.user.UserInsertProAction;
import com.jslhrd.service.user.UserLoginAction;
import com.jslhrd.service.user.UserLoginProAction;
import com.jslhrd.service.user.UserLogoutAction;
import com.jslhrd.service.user.UserModifyAction;
import com.jslhrd.service.user.UserModifyProAction;

public class UserActionFactory {

	private UserActionFactory() {}
	private static UserActionFactory instance = new UserActionFactory();
	public static UserActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String cmd) {
		
		Action action = null;
		System.out.println("UserActionFactory :" + cmd);
		
		if(cmd.equals("user_login")) {
			action = new UserLoginAction();
		} else if (cmd.equals("user_login_pro")) {
			action = new UserLoginProAction();
		} else if (cmd.equals("user_logout")) {
			action = new UserLogoutAction();
		} else if (cmd.equals("user_insert")) {
			action = new UserInsertAction();
		} else if (cmd.equals("user_insert_pro")) {
			action = new UserInsertProAction();
		} else if (cmd.equals("user_idcheck")) {
			action = new UserIdcheckAction();
		} else if (cmd.equals("user_modify")) {
			action = new UserModifyAction();
		} else if (cmd.equals("user_modify_pro")) {
			action = new UserModifyProAction();
		}
		return action;
	}
}
