
package project.controller.jobopening;

import project.controller.Action;
import project.service.jobopening.JobOpeningDetailAction;
import project.service.jobopening.JobOpeningSearchAction;
import project.service.jobopening.JobOpenningListAction;

public class JobOpeningActionFactory {
	//게시판 전용 팩토리
	private static JobOpeningActionFactory instance = new JobOpeningActionFactory();
	
	private JobOpeningActionFactory() {}
	
	public static JobOpeningActionFactory getInstance() {
		return instance;
	}
	public Action getAction(String cmd) {
		Action action = null;
		System.out.println("Job_openingActionFactory :"  + cmd);
		if(cmd.equals("job_opening_insert")) {
			action = null; 
		}if(cmd.equals("job_opening_list")) {
			action = new JobOpenningListAction(); 
		}if(cmd.equals("company_job_opening_detail")) {
			action = new JobOpeningDetailAction();
		}if(cmd.equals("company_job_opening_search")) {
			action = new JobOpeningSearchAction();
		}
				
		return action;
	}
	
}
