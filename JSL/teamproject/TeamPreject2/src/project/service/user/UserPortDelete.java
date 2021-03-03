package project.service.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.controller.Action;
import project.domain.user.UserDAO;

public class UserPortDelete implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int port_num = Integer.parseInt(request.getParameter("port_num"));
		UserDAO DAO = UserDAO.getInstance();
		int row = DAO.userPortDelete(port_num);
		
		request.setAttribute("row", row);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/User/user_port_delete_pro.jsp");
		dispatcher.forward(request, response);
	}

}
