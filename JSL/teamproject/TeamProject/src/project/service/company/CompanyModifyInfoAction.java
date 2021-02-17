package project.service.company;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.controller.Action;

public class CompanyModifyInfoAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			System.out.println("CompanyModifyInfoAction");
			
			RequestDispatcher rd = request.getRequestDispatcher("/Company/company_modify_info.jsp");
			rd.forward(request, response);
	}
	

}
