package project.service.company;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.controller.Action;
import project.domain.company.CompanyDAO;
import project.domain.company.CompanyVO;
import project.util.SHA256Util;

public class CompanyLoginProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login pro action");
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("com_id");
		String pass = SHA256Util.getEncSHA256(request.getParameter("com_pass"));
		String language = request.getParameter("language");
		
		int row = -99;
		CompanyDAO dao = CompanyDAO.getInstanceof();
		row = dao.CompanyLogin(id, pass);
		if(row == 1) {
			CompanyVO vo = dao.companyInfo(id);
			HttpSession session = request.getSession();
			
			
			session.setAttribute("comvo", vo);
			
			session.setMaxInactiveInterval(3600);
		}
		request.setAttribute("language", language);
		request.setAttribute("row", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("Company/company_login_pro.jsp");
		rd.forward(request, response);
	}

}
