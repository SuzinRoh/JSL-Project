package project.service.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.controller.Action;
import project.domain.user.UserCoverLetterVO2;
import project.domain.user.UserDAO;
import project.domain.user.UserVO;

public class UserCoverLetterView2 implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String language = "";
		if(request.getHeader("accept-language") != null) {
			language = request.getHeader("accept-language");
			language = language.substring(0,2);
		}
		
		int cover_num = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		HttpSession session = request.getSession();
		
		UserDAO dao = UserDAO.getInstance();
		UserCoverLetterVO2 ucvl = null;
		int row = 0;
		if(session.getAttribute("user") != null) {
			UserVO vo = (UserVO)session.getAttribute("user");
			ucvl = dao.userCoverLetterView(vo.getUser_num(), cover_num);
				
			if(ucvl == null) {
				
				row = -2;
			}else {
				ucvl.setCover_contents(ucvl.getCover_contents().replace("\n", "<br>"));
			}
		}else {
			row = -1;
		}
		request.setAttribute("language", language);
		request.setAttribute("row", row);
		request.setAttribute("ucvl", ucvl);
		request.setAttribute("page", page);
		
		RequestDispatcher rd = request.getRequestDispatcher("User/user_cover_letter_view.jsp");
		rd.forward(request, response);
	}

}
