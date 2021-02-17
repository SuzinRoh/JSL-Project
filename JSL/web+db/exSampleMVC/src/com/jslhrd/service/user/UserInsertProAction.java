package com.jslhrd.service.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.user.UserDAO;
import com.jslhrd.domain.user.UserVO;
import com.jslhrd.service.Action;
import com.jslhrd.util.SHA256Util;

public class UserInsertProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserInsertProAction");
		
		UserDAO dao = UserDAO.getInstance();
		UserVO vo = new UserVO();
		
		vo.setName(request.getParameter("name"));
		vo.setUserid(request.getParameter("userid"));
		vo.setPasswd(SHA256Util.getEncSHA256(request.getParameter("passwd")));
		
		String email="";
		if(!request.getParameter("email2").equals("")) {
			email = request.getParameter("email1")+"@"+request.getParameter("email2");
		} else {
			email = request.getParameter("email1")+"@"+request.getParameter("email3");
		}
		
		
		vo.setEmail(email);
		vo.setTel(request.getParameter("tel"));
		
		int row = dao.UserInsert(vo);
		
		request.setAttribute("row", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("Users/user_insert_pro.jsp");
		rd.forward(request, response);
	}

}
