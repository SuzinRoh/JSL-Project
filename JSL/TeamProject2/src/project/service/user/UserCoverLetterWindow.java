package project.service.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.controller.Action;
import project.domain.user.UserCoverLetterVO2;
import project.domain.user.UserDAO;
import project.domain.user.UserVO;
import project.util.PageIndex;

public class UserCoverLetterWindow implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UserDAO dao = UserDAO.getInstance();
		int totcount = 0;
		
		HttpSession session = request.getSession();
		
		UserVO vo = null;
		if(session.getAttribute("user") != null) {
			vo = (UserVO)session.getAttribute("user");
			totcount = dao.userCoverLetterCount(vo.getUser_num());
			
		}
		
		
		int nowpage = 1;
		int maxlist = 10;
		int totpage = 1;
	
		if(totcount % maxlist == 0) {
			totpage = totcount / maxlist;
		}else {
			totpage = totcount / maxlist +1;
		}
		
		if(totcount == 0) totpage = 1;
		
		if(request.getParameter("page") != null) {
			nowpage = Integer.parseInt(request.getParameter("page"));
		}
		if(nowpage>totpage) nowpage = totpage;
		
		int startpage = (nowpage-1)*maxlist +1;
		int endpage = nowpage * maxlist;
		int listcount = totcount - ((nowpage-1)*maxlist);
		
		List<UserCoverLetterVO2> list = null;
		
		if(session.getAttribute("user") != null) {
			list = dao.userCoverLetterList(startpage, endpage, vo.getUser_num());
		}
		
		
		String pageSkip = "";
		pageSkip = PageIndex.pageList(nowpage, totpage, "User?cmd=user_cover_letter_window", "");
		
		// 기능 사용 보류
		request.setAttribute("totcount", totcount);
		request.setAttribute("totpage", totpage);
		request.setAttribute("page", nowpage);
		request.setAttribute("listcount", listcount);
		request.setAttribute("list", list);
		request.setAttribute("pageSkip", pageSkip);
		
		RequestDispatcher rd = request.getRequestDispatcher("User/user_cover_letter_window.jsp");
		rd.forward(request, response);

	}

}
