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

public class UserResumeInsert implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int row = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			UserVO vo = (UserVO) session.getAttribute("user");
			UserDAO dao = UserDAO.getInstance();
			row = dao.userResumeCount(vo.getUser_num());
		}

		request.setAttribute("row", row);

		RequestDispatcher rd = request.getRequestDispatcher("User/user_resume_insert.jsp");
		rd.forward(request, response);
	}

}
