package project.service.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.controller.Action;
import project.domain.user.UserDAO;

public class UserIdCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid = request.getParameter("userid");
		PrintWriter out = response.getWriter();
		UserDAO DAO = UserDAO.getInstance();
		int row = DAO.userIdcheck(userid);
		out.print(row);
		
		
	}

}
