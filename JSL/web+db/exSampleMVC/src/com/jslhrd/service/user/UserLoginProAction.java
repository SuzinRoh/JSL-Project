package com.jslhrd.service.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jslhrd.domain.user.UserDAO;
import com.jslhrd.domain.user.UserVO;
import com.jslhrd.service.Action;
import com.jslhrd.util.SHA256Util;

public class UserLoginProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserLoginPro");
		String id = request.getParameter("userid");
		String pass = SHA256Util.getEncSHA256(request.getParameter("passwd"));
		
	
		UserDAO dao = UserDAO.getInstance();
		
		int row = dao.UserIdCheck(id, pass);
		if(row == 1 ) {
			UserVO vo = dao.UserSelect(id);
			
			HttpSession session = request.getSession();
			session.setAttribute("Session_User", vo);
			session.setMaxInactiveInterval(1800);
		}
		
		
		request.setAttribute("row", row);
		RequestDispatcher rd = request.getRequestDispatcher("Users/user_login_pro.jsp");
		rd.forward(request, response);
	}

}
