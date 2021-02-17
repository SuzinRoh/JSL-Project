package com.jslhrd.service.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.user.UserDAO;
import com.jslhrd.service.Action;

public class UserIdcheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserIdcheckAction");
		String userid = request.getParameter("userid");
		
		UserDAO dao = UserDAO.getInstance();
		
		//id중복체크 dao메소드
		
		int row= dao.UserIdCheck(userid);
		
		request.setAttribute("row", row);
		request.setAttribute("userid", userid);
		
		RequestDispatcher rd = request.getRequestDispatcher("Users/user_idcheck.jsp");
		rd.forward(request, response);
	}

}
