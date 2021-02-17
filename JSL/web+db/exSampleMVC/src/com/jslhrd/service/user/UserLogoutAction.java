package com.jslhrd.service.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jslhrd.service.Action;

public class UserLogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserLogout");
		String name = request.getParameter("username");
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		request.setAttribute("name", name);
		RequestDispatcher rd = request.getRequestDispatcher("Users/user_logout.jsp");
		rd.forward(request, response);
	}

}
