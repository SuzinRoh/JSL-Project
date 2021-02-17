package project.controller.main;

import project.controller.Action;
import project.service.main.MainAction;
import project.service.main.MainJoinFormAction;
import project.service.main.MainLoginFormAction;

public class MainActionFactory {
	//메 전용 팩토리
	private static MainActionFactory instance = new MainActionFactory();
	
	private MainActionFactory() {}
	
	public static MainActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String cmd) {
		Action action = null;
		System.out.println("MainActionFactory :"  + cmd);
		if(cmd.equals("main_index")) {
			action = new MainAction();
		}if(cmd.equals("login_form")) {
			action = new MainLoginFormAction();
		}if(cmd.equals("join_form")) {
			action = new MainJoinFormAction();
		}
				
		return action;
	}
	
}
