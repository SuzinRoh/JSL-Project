package project.controller.user;

import project.controller.Action;
import project.service.user.UserCoverLetterDelete;
import project.service.user.UserCoverLetterInsert;
import project.service.user.UserCoverLetterInsertPro;
import project.service.user.UserCoverLetterList;
import project.service.user.UserCoverLetterModify;
import project.service.user.UserCoverLetterModifyPro;
import project.service.user.UserCoverLetterSelect;
import project.service.user.UserCoverLetterView2;
import project.service.user.UserCoverLetterWindow;
import project.service.user.UserDeleteAction;
import project.service.user.UserDeleteProAction;
import project.service.user.UserDownAction;
import project.service.user.UserEmailAuth;
import project.service.user.UserGmailCheck;
import project.service.user.UserIdCheckAction;
import project.service.user.UserInsertAction;
import project.service.user.UserInsertProAction;
import project.service.user.UserLoginAction;
import project.service.user.UserLoginProAction;
import project.service.user.UserLogoutAction;
import project.service.user.UserModifyAction;
import project.service.user.UserModifyProAction;
import project.service.user.UserMyInfo;
import project.service.user.UserPortDelete;
import project.service.user.UserPortList;
import project.service.user.UserPortModify;
import project.service.user.UserPortModifyPro;
import project.service.user.UserResumeInsert;
import project.service.user.UserResumeInsertPro;
import project.service.user.UserResumeList;
import project.service.user.UserResumeModify;
import project.service.user.UserResumeModifyPro;
import project.service.user.UserResumeView;
import project.service.user.UserSearchId;
import project.service.user.UserSearchIdPro;
import project.service.user.UserSearchPass;
import project.service.user.UserSearchPassPro;
import project.service.user.UserWritePort;
import project.service.user.UserWritePortPro;

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
		if(cmd.equals("user_insert")) {
			action = new UserInsertAction();
		}
		else if(cmd.equals("user_insert_pro")) {
			action = new UserInsertProAction();
		}
		else if(cmd.equals("user_idcheck")) {
			action = new UserIdCheckAction();
		}
		else if(cmd.equals("user_emailcheck")) {
			action = new UserEmailAuth();
			
		}else if(cmd.equals("user_gmailCheck")) {
			action = new UserGmailCheck();
		}
		else if(cmd.equals("user_login")) {
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
		else if(cmd.equals("user_myinfo")) {
			action = new UserMyInfo();
		}
		else if(cmd.equals("user_modify")) {
			action = new UserModifyAction();
		}
		else if(cmd.equals("user_modify_pro")) {
			action = new UserModifyProAction();
		}
		else if(cmd.equals("user_delete")) {
			action = new UserDeleteAction();
		}
		else if(cmd.equals("user_delete_pro")) {
			action = new UserDeleteProAction();
		}
		else if(cmd.equals("user_logout")) {
			action = new UserLogoutAction();
		}
		else if(cmd.equals("user_write_port")) {
			action = new UserWritePort();
		}
		else if(cmd.equals("user_write_port_pro")) {
			action = new UserWritePortPro();
		}
		else if(cmd.equals("user_port_list")) {
			action = new UserPortList();
		}
		else if(cmd.equals("user_port_modify")) {
			action = new UserPortModify();
		}
		else if(cmd.equals("user_port_modify_pro")) {
			action = new UserPortModifyPro();
		}
		else if(cmd.equals("user_port_delete")) {
			action = new UserPortDelete();
		}

		/*
		else if(cmd.equals("user_index")) {
			action = new UserIndex();
		}
		*/
		else if(cmd.equals("user_gmailCheck")) {
			action = new UserGmailCheck();
		}
		else if(cmd.equals("user_login")) {
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
		else if(cmd.equals("user_cover_letter_insert")) {
			action = new  UserCoverLetterInsert();
		}
		else if(cmd.equals("user_cover_letter_insert_pro")) {
			action = new  UserCoverLetterInsertPro();
		}
		else if(cmd.equals("user_cover_letter_list")) {
			action = new  UserCoverLetterList();
		}
		else if(cmd.equals("user_cover_letter_window")) {
			action = new  UserCoverLetterWindow();
		}
		else if(cmd.equals("user_cover_letter_select")) {
			action = new  UserCoverLetterSelect();
		}
		else if(cmd.equals("user_cover_letter_view")) {
			action = new  UserCoverLetterView2();
		}
		else if(cmd.equals("user_cover_letter_modify")) {
			action = new  UserCoverLetterModify();
		}
		else if(cmd.equals("user_cover_letter_modify_pro")) {
			action = new  UserCoverLetterModifyPro();
		}
		else if(cmd.equals("user_cover_letter_delete")) {
			action = new  UserCoverLetterDelete();
		}
		else if(cmd.equals("user_resume_insert")) {
			action = new  UserResumeInsert();
		}
		else if(cmd.equals("user_resume_insert_pro")) {
			action = new  UserResumeInsertPro();
		}
		else if(cmd.equals("user_resume_list")) {
			action = new  UserResumeList();
		}
		else if(cmd.equals("user_resume_view")) {
			action = new  UserResumeView();
		}
		else if(cmd.equals("user_down")) {
			action = new  UserDownAction();
		}
		else if(cmd.equals("user_resume_modify")) {
			action = new  UserResumeModify();
		}
		else if(cmd.equals("user_resume_modify_pro")) {
			action = new  UserResumeModifyPro();
		}
		return action;
	}
}
