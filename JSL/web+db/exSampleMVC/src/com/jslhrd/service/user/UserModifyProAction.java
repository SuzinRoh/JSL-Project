package com.jslhrd.service.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.user.UserDAO;
import com.jslhrd.service.Action;
import com.jslhrd.util.SHA256Util;

public class UserModifyProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserModifyAction");
		
		UserDAO dao = UserDAO.getInstance();
		String id = request.getParameter("userid");
		String passwd = SHA256Util.getEncSHA256(request.getParameter("newpasswd"));
		String oldpw = SHA256Util.getEncSHA256(request.getParameter("oldpw"));
		
		
		int row = dao.UserModify(oldpw, passwd, id);
		
		request.setAttribute("row", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("Users/user_modify_pro.jsp");
		rd.forward(request, response);
	}

}
