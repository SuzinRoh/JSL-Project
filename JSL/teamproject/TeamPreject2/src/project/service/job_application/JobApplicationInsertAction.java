package project.service.job_application;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.controller.Action;
import project.domain.company.CompanyVO;
import project.domain.job_opening.Job_openingDAO;

public class JobApplicationInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int opening_num = 0; /// 없앨 것
		if(request.getParameter("num")!=null) { // if문 없앨 것
			opening_num  = Integer.parseInt(request.getParameter("num"));
		}
		Job_openingDAO j_dao = Job_openingDAO.getInstanceof();
	
		
		int com_num = j_dao.selectCom_num(opening_num);
		
		request.setAttribute("num", com_num);
		
		CompanyVO vo = j_dao.selectJobOpening(com_num);
		request.setAttribute("openingnum", opening_num);
		request.setAttribute("vo", vo);
		RequestDispatcher rd =request.getRequestDispatcher("Job/job_application_insert.jsp");
		rd.forward(request, response);
	}

}
