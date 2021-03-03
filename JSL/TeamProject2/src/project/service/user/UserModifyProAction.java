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

public class UserModifyProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDAO DAO = UserDAO.getInstance();
		HttpSession session = request.getSession();
		UserVO vo = (UserVO)session.getAttribute("user");
		String userpass = SHA256Util.getEncSHA256(request.getParameter("userpass"));
		String usertel = request.getParameter("usertel");
		String newuserpass = SHA256Util.getEncSHA256(request.getParameter("newuserpass"));
		vo.setUser_pass(userpass);
		vo.setUser_newpass(newuserpass);
		vo.setUser_tel(usertel);
		int row = DAO.userModify(vo);
		
		request.setAttribute("row", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("/User/user_modify_pro.jsp");
		rd.forward(request, response);
	}

}
