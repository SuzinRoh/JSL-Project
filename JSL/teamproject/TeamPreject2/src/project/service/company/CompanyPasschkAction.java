package project.service.company;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.controller.Action;
import project.domain.company.CompanyDAO;
import project.util.SHA256Util;

public class CompanyPasschkAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		String pass = SHA256Util.getEncSHA256(request.getParameter("pass"));
		PrintWriter out = response.getWriter();
		CompanyDAO dao = CompanyDAO.getInstanceof();
		int row = dao.companyPasschk(id, pass);
		
		out.print(row);
	}

}
