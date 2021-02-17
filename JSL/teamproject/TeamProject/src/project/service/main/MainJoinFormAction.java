package project.service.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.controller.Action;

public class MainJoinFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MainJoinFormAction");
		
		if(request.getParameter("btn") != null) {
			String tmp = request.getParameter("btn");
			System.out.println(tmp);
			request.setAttribute("tmp", tmp);
		} else {
			String tmp = null;
			request.setAttribute("tmp", tmp);
		}
			
		
		RequestDispatcher rd = request.getRequestDispatcher("Main/join_form.jsp");
		rd.forward(request, response);

	}

}
