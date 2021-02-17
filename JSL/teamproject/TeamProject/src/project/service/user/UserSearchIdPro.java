package project.service.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.controller.Action;
import project.domain.user.UserDAO;

public class UserSearchIdPro implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String language = "";
		if(request.getHeader("accept-language") != null) {
			language = request.getHeader("accept-language");
			language = language.substring(0,2);
		}
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		UserDAO dao = UserDAO.getInstance();
		String userid = dao.userSearchId(name,email);
		
		request.setAttribute("userid", userid);
		request.setAttribute("language", language);
		
		RequestDispatcher rd = request.getRequestDispatcher("User/User_Search_Id_Pro.jsp");
		rd.forward(request, response);
	}

}
