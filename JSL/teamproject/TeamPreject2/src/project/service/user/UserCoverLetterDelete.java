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

public class UserCoverLetterDelete implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String language = "";
		if(request.getHeader("accept-language") != null) {
			language = request.getHeader("accept-language");
			language = language.substring(0,2);
		}
		
		int cover_num = Integer.parseInt(request.getParameter("idx"));
		
		HttpSession session = request.getSession();
		
		UserDAO dao = UserDAO.getInstance();
		int row = 0;
		if(session.getAttribute("user") != null) {
			UserVO vo = (UserVO)session.getAttribute("user");
			row = dao.userCoverLetterDelete(vo.getUser_num(), cover_num);
		}
		
		request.setAttribute("row", row);
		request.setAttribute("language", language);
		
		RequestDispatcher rd = request.getRequestDispatcher("User/user_cover_letter_delete.jsp");
		rd.forward(request, response);
		
	}

}
