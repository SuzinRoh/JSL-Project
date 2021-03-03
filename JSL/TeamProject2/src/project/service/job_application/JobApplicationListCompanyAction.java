package project.service.job_application;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.controller.Action;
import project.domain.JobApplication.Job_ApplicationDAO;
import project.domain.JobApplication.Job_ApplicationVO;
import project.domain.company.CompanyDAO;
import project.domain.company.CompanyVO;
import project.domain.user.UserResumeVO2;

public class JobApplicationListCompanyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CompanyVO comvo = (CompanyVO)session.getAttribute("comvo");
		
		
		Job_ApplicationDAO dao = Job_ApplicationDAO.getInstanceof();
		CompanyDAO com_dao = CompanyDAO.getInstanceof();
		
		List<Job_ApplicationVO> list = dao.jobApplicationUserSelect(comvo.getCom_num());
		List<UserResumeVO2> ur = new ArrayList<UserResumeVO2>();
		
		Iterator<Job_ApplicationVO> iter = list.iterator();
		while(iter.hasNext()) {
			Job_ApplicationVO vo = iter.next();
			UserResumeVO2 temp = com_dao.userResumeGetLink(vo.getUser_num());
			ur.add(temp);
		}
		
		
		int application_count = dao.countApplication(comvo.getCom_num());
		
		
		request.setAttribute("application_count", application_count);
		request.setAttribute("list", list);
		request.setAttribute("ur", ur);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Job/job_application_view(company).jsp");
		rd.forward(request, response);
		

	}

}
