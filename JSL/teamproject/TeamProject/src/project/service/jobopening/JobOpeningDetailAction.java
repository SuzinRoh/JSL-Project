package project.service.jobopening;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.controller.Action;
import project.domain.company.CompanyVO;
import project.domain.jobopening.JobOpeningDAO;
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
		
		//CompanyDAO dao = CompanyDAO.getInstanceof();
		JobOpeningDAO dao = JobOpeningDAO.getInstanceof();
		
		
		CompanyVO vo = dao.companyDetail(num);

		List<CompanyVO> list = dao.openingListRecommend();
		
		
//		System.out.println(vo2.getCom_num());
//		
		
		request.setAttribute("list", list);
		request.setAttribute("vo",vo);
		RequestDispatcher rd =request.getRequestDispatcher("Job_opening/job_opening_detail.jsp");
		rd.forward(request, response);
	}

}
