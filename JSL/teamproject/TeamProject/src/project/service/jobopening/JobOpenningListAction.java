package project.service.jobopening;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.controller.Action;
import project.domain.company.CompanyDAO;
import project.domain.company.CompanyVO;
import project.domain.jobopening.JobOpeningDAO;

public class JobOpenningListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CompanyDAO dao = CompanyDAO.getInstanceof();
		JobOpeningDAO j_dao = JobOpeningDAO.getInstanceof();
		
		
		
		
		List<CompanyVO> list = j_dao.openingList();
		int count = j_dao.countjobOpening();
	
	
		request.setAttribute("count", count);
		request.setAttribute("list", list);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/Job_opening/job_opening_list.jsp");
		rd.forward(request, response);
		
		
		
		
		
		
	}

}
