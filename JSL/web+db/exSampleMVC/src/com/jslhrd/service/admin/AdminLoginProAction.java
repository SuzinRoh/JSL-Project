package com.jslhrd.service.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jslhrd.service.Action;

public class AdminLoginProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("AdminLoginProAction");
		
		String id = request.getParameter("adminid");
		String pw =request.getParameter("adminpass");
		int row =0;
		if(id.equals("1234") && pw.equals("1234")) {
			
			HttpSession sess = request.getSession();
			
			sess.setAttribute("admin", id);
			sess.setMaxInactiveInterval(1800);
			
			row=1;
			
		} 
		
	
		request.setAttribute("row", row);
		RequestDispatcher rd = request.getRequestDispatcher("Admin/index_pro.jsp");
		rd.forward(request, response);
		
	}

}
