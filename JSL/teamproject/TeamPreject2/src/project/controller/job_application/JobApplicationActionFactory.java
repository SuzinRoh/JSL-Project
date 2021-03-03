package project.controller.job_application;



import project.controller.Action;
import project.service.job_application.JobApplicationInsertAction;
import project.service.job_application.JobApplicationInsertProAction;
import project.service.job_application.JobApplicationListCompanyAction;
import project.service.job_application.JobApplicationListUserAction;



public class JobApplicationActionFactory {
private static JobApplicationActionFactory instance = new JobApplicationActionFactory();
	
	private JobApplicationActionFactory() {
		
	}
	
	public static JobApplicationActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String cmd) {
		Action action = null;
		System.out.println("Job_applicationActionFactory : " + cmd);
		if(cmd.equals("job_application_insert")) {
			action = new JobApplicationInsertAction();
		}else if(cmd.equals("job_application_view_company")) {
			action = new JobApplicationListCompanyAction();
		}else if(cmd.equals("job_application_insert_pro")) {
			action = new JobApplicationInsertProAction();
		}else if(cmd.equals("job_application_view_user")) {
			action = new JobApplicationListUserAction();
		}
		
		return action;
	}
}
