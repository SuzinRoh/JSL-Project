package project.service.company;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.controller.Action;
import project.domain.company.CompanyDAO;

public class CompanyIdfoundProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String language = "";
		if(request.getHeader("accept-language")!=null) {
			language = request.getHeader("accept-language");
		}
		language = language.substring(0,2);
		request.setAttribute("language", language);
		
		String email = request.getParameter("com_email");
		String name = request.getParameter("com_name");
		int row = 0;
		CompanyDAO dao = CompanyDAO.getInstanceof();
		String id = dao.companyIdfound(name, email);
		if(id!="") {
			row = 1;
		}
		request.setAttribute("id", id);
		request.setAttribute("row", row);
		RequestDispatcher rd = request.getRequestDispatcher("/Company/company_idfound_pro.jsp");
		rd.forward(request, response);
	}

}
