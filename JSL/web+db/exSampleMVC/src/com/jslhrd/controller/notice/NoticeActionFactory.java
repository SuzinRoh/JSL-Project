package com.jslhrd.controller.notice;

import com.jslhrd.service.Action;
import com.jslhrd.service.notice.NoticeListAction;
import com.jslhrd.service.notice.NoticeViewAction;

public class NoticeActionFactory {

	private NoticeActionFactory() {}
	private static NoticeActionFactory instance = new NoticeActionFactory();
	public static NoticeActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String cmd) {
		
		Action action = null;
		System.out.println("UserActionFactory :" + cmd);
		
		if(cmd.equals("notice_list")) {
			action = new NoticeListAction();
		} else if(cmd.equals("notice_view")) {
			action = new NoticeViewAction();
		}
		return action;
	}
}
