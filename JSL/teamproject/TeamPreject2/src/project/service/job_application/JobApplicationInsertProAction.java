package project.service.job_application;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.controller.Action;
import project.domain.JobApplication.Job_ApplicationDAO;
import project.domain.company.CompanyDAO;
import project.domain.company.CompanyVO;
import project.domain.job_opening.Job_openingDAO;
import project.domain.job_opening.Job_openingVO;

public class JobApplicationInsertProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int com_num = Integer.parseInt(request.getParameter("com_num"));
		int user_num = Integer.parseInt(request.getParameter("user_num"));
		int openingnum = Integer.parseInt(request.getParameter("openingnum"));
		
		Job_ApplicationDAO dao = Job_ApplicationDAO.getInstanceof();
		int row = dao.jobApplicationInsert(com_num, user_num, openingnum);
		
		
		request.setAttribute("row", row);
		request.setAttribute("num", openingnum);
		
		
				
		
		
		RequestDispatcher rd =request.getRequestDispatcher("Job/job_application_insert_pro.jsp");
		rd.forward(request, response);
	}

}
