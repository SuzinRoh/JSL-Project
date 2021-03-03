package project.service.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.controller.Action;
import project.domain.user.UserDAO;
import project.domain.user.UserPortVO;

public class UserPortModify implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int port_num =Integer.parseInt(request.getParameter("port_num"));
		UserDAO DAO = UserDAO.getInstance();
		UserPortVO vo =  new UserPortVO();
		vo = DAO.userPortSelect(port_num);
		
		
		request.setAttribute("portfolio", vo);

		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/User/user_port_modify.jsp");
		dispatcher.forward(request, response);
	}

}
