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

public class UserCoverLetterInsertPro implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String language = "";
		if(request.getHeader("accept-language") != null) {
			language = request.getHeader("accept-language");
			language = language.substring(0,2);
		}
		
		String subject = request.getParameter("subject");
		String contents = request.getParameter("contents");
		String set_private = request.getParameter("set_private");
		
		HttpSession session = request.getSession();
		
		UserDAO dao = UserDAO.getInstance();
		int row;
		if(session.getAttribute("user") == null) {
			row = -1;
		}else {
			UserVO vo = (UserVO)session.getAttribute("user");
			row = dao.userCoverLetterInsert(subject, contents, set_private,vo.getUser_num());
		}
		
		request.setAttribute("language", language);
		request.setAttribute("row", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("User/user_cover_letter_insert_pro.jsp");
		rd.forward(request, response);
	}

}
