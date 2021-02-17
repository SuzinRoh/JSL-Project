package project.service.companyinsert;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.domain.company.CompanyVO;
import project.service.Action;

public class CompanyInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("company insert action");
		int row = 0;
		
		if(request.getParameter("row") != null ) {
			row = Integer.parseInt(request.getParameter("row"));
			//System.out.println("1");
			
			if(request.getParameter("id") != null) {
				//System.out.println("2");
				
				String id = request.getParameter("id");
				String pass = request.getParameter("pass");
				//System.out.println(pass);
				String email = request.getParameter("email");
				
				request.setAttribute("id", id);
				request.setAttribute("pass", pass);
				request.setAttribute("email", email);
			}
		}
		request.setAttribute("row", row);
		RequestDispatcher rd = request.getRequestDispatcher("Company/company_insert.jsp");
		rd.forward(request, response);
		

	}

}
