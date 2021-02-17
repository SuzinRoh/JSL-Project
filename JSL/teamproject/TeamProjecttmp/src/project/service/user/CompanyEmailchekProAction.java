package project.service.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.domain.company.CompanyDAO;
import project.service.Action;

public class CompanyEmailchekProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 //System.out.println("company email check pro action");
		 
		 String id = request.getParameter("id");
		 CompanyDAO dao = CompanyDAO.getInstance();
		 int row =dao.companyMailchk(id);
		 
		 request.setAttribute("row", row);
		 RequestDispatcher rd = request.getRequestDispatcher("Company/company_email_chk_pro.jsp");
		 rd.forward(request, response);
		 
	}

}
