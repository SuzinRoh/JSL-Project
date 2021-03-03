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

public class UserDeleteProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDAO DAO = UserDAO.getInstance();
		HttpSession session = request.getSession();
		UserVO vo = (UserVO)session.getAttribute("user");
		String userid = vo.getUser_id();
		String userpass = SHA256Util.getEncSHA256(request.getParameter("userpass"));
		
		int row = DAO.userDelete(userid,userpass);
		if(row == 1) {
			session.invalidate();
		}
		
		request.setAttribute("row", row);
		RequestDispatcher rd = request.getRequestDispatcher("/User/user_delete_pro.jsp");
		rd.forward(request, response);
	}

}
