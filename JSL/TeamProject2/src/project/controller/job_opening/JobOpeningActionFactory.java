package project.controller.job_opening;

import project.controller.Action;
import project.service.job_opening.JobOpeningDetailAction;
import project.service.job_opening.JobOpeningInsertAction;
import project.service.job_opening.JobOpeningInsertProAction;
import project.service.job_opening.JobOpeningListAction;
import project.service.job_opening.JobOpeningSearchAction;

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
			action = new JobOpeningInsertAction();
		}else if(cmd.equals("job_opening_insert_pro")) {
			action = new JobOpeningInsertProAction();
		}else if(cmd.equals("job_opening_list")) {
			action = new JobOpeningListAction(); 
		}else if(cmd.equals("company_job_opening_detail")) {
			action = new JobOpeningDetailAction();
		}else if(cmd.equals("company_job_opening_search")) {
			action = new JobOpeningSearchAction();
		}
				
		return action;
	}
	
}
