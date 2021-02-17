package project.service.jobopening;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.controller.Action;
import project.domain.company.CompanyDAO;
import project.domain.company.CompanyVO;
import project.domain.jobopening.JobOpeningVO;

public class JobOpeningDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String id = request.getParameter("id");
//		
//		CompanyDAO dao = CompanyDAO.getInstanceof();
//		dao.companyInfo(id);
		System.out.println("CompanyInfoDetailAction");
		
		int num  = Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		
		CompanyDAO dao = CompanyDAO.getInstanceof();
		
		JobOpeningVO vo1= dao.comGetJobOpening(num);
		CompanyVO vo2 = dao.companyList(num);
		
		List<CompanyVO> list = dao.companyListJoin();
		
//		System.out.println(vo1.getCom_num2());
//		System.out.println(vo2.getCom_num());
//		
		
		request.setAttribute("list", list);
		request.setAttribute("jobopeningvo",vo1);
		request.setAttribute("companyvo",vo2);
		RequestDispatcher rd =request.getRequestDispatcher("Job_opening/job_opening_detail.jsp");
		rd.forward(request, response);
	}

}
