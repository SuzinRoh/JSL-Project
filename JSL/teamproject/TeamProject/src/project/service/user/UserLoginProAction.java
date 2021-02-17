package project.service.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.controller.Action;
import project.domain.user.UserDAO;
import project.domain.user.UserVO;
import project.util.SHA256Util;

public class UserLoginProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String language = "";
		if(request.getHeader("accept-language") != null) {
			language = request.getHeader("accept-language");
			language = language.substring(0,2);
		}
		
		
		String userid = request.getParameter("userid");
		//String passwd = request.getParameter("passwd");
		String passwd = SHA256Util.getEncSHA256(request.getParameter("passwd"));
		
		
		UserDAO dao = UserDAO.getInstance();
		int row = dao.userLogin(userid, passwd);
		
		
		if(row == 1) {
			HttpSession session = request.getSession();
			UserVO user = dao.userSelect(userid);
			session.setMaxInactiveInterval(1800);
			session.setAttribute("user", user);
		}
		
		request.setAttribute("row", row);
		request.setAttribute("language", language);
		
		RequestDispatcher rd = request.getRequestDispatcher("User/User_Login_Pro.jsp");
		rd.forward(request, response);
	}

}
