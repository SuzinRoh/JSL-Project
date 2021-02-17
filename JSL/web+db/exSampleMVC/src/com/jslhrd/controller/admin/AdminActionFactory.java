package com.jslhrd.controller.admin;

import com.jslhrd.service.Action;
import com.jslhrd.service.admin.AdminLoginAction;
import com.jslhrd.service.admin.AdminLoginProAction;
import com.jslhrd.service.admin.AdminLogoutAction;
import com.jslhrd.service.admin.AdminMainAction;
import com.jslhrd.service.admin.notice.AdminNoticeListAction;
import com.jslhrd.service.admin.notice.AdminNoticeModifyAction;
import com.jslhrd.service.admin.notice.AdminNoticeModifyProAction;
import com.jslhrd.service.admin.notice.AdminNoticeViewAction;
import com.jslhrd.service.admin.notice.AdminNoticeWriteAction;
import com.jslhrd.service.admin.notice.AdminNoticeWriteProAction;

public class AdminActionFactory {
	private AdminActionFactory() {}
	private static AdminActionFactory instance = new AdminActionFactory();
	public static AdminActionFactory getInstace() {
		return instance;
	}
	
	public Action getAction(String cmd) {
		Action action = null;
		System.out.println("AdminActionFactory :" + cmd);
		if(cmd.equals("admin_index")) {
			action = new AdminLoginAction();
		} else if(cmd.equals("admin_index_pro")) {
			action = new AdminLoginProAction();
		} else if(cmd.equals("admin_main")) {
			action = new AdminMainAction();
		} else if(cmd.equals("admin_notice_list")) {
			action = new AdminNoticeListAction();
		} else if(cmd.equals("admin_notice_write")) {
			action = new AdminNoticeWriteAction();
		} else if(cmd.equals("admin_notice_write_pro")) {
			action = new AdminNoticeWriteProAction();
		} else if(cmd.equals("admin_notice_view")) {
			action = new AdminNoticeViewAction();
		} else if(cmd.equals("admin_notice_modify")) {
			action = new AdminNoticeModifyAction();
		} else if(cmd.equals("admin_notice_modify_pro")) {
			action = new AdminNoticeModifyProAction();
		} else if(cmd.equals("admin_logout")) {
			action = new AdminLogoutAction();
		}  
		return action;
	}
}
