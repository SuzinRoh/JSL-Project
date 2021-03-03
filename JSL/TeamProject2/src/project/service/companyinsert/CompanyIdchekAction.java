package project.service.companyinsert;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.controller.Action;
import project.domain.company.CompanyDAO;

public class CompanyIdchekAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("company id check action");
		
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		CompanyDAO dao = CompanyDAO.getInstanceof();
		int row = dao.companyIdchk(id);
		
		out.print(row);
		
		
	}

}
