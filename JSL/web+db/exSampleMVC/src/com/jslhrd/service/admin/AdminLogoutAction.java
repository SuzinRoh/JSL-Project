package com.jslhrd.service.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jslhrd.service.Action;

public class AdminLogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();//세션객체생성
		session.invalidate();
		
		RequestDispatcher rd = request.getRequestDispatcher("Main/index.jsp");
		rd.forward(request, response);
	}

}
