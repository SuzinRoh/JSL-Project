package com.jslhrd.service.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.service.Action;

public class AdminLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AdminLoginAction");
		
		RequestDispatcher rd = request.getRequestDispatcher("Admin/index.jsp");
		rd.forward(request, response);
	}

}
