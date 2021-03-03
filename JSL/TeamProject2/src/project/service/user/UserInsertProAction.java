package project.service.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.controller.Action;
import project.domain.user.UserDAO;
import project.domain.user.UserVO;
import project.util.SHA256Util;

public class UserInsertProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		System.out.print(request.getParameter("username"));
		UserVO vo = new UserVO();
		UserDAO DAO = UserDAO.getInstance();
		vo.setUser_email(request.getParameter("useremail"));
		vo.setUser_id(request.getParameter("userid"));
		vo.setUser_name(request.getParameter("username"));
		vo.setUser_pass(SHA256Util.getEncSHA256(request.getParameter("userpass")));
		vo.setUser_tel(request.getParameter("usertel"));
		
		int row = DAO.userInsert(vo);
		
		request.setAttribute("row", row);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/User/user_insert_pro.jsp");
		dispatcher.forward(request, response);
	}

}
