package project.service.company;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.controller.Action;
import project.domain.company.CompanyDAO;
import project.domain.company.CompanyVO;

public class CompanyInfomationAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int num = Integer.parseInt(request.getParameter("num"));
		CompanyDAO dao = CompanyDAO.getInstanceof();
		 CompanyVO vo = dao.companyInfomation(num);
		
		
		System.out.println("z");
		request.setAttribute("vo", vo);
		RequestDispatcher rd = request.getRequestDispatcher("/Company/company_infomation.jsp");
		rd.forward(request, response);
	}

}
