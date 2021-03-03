package project.service.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.controller.Action;
import project.domain.user.UserCoverLetterVO2;
import project.domain.user.UserDAO;
import project.domain.user.UserResumeVO2;
import project.domain.user.UserVO;

public class UserResumeView implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String language = "";
		if(request.getHeader("accept-language") != null) {
			language = request.getHeader("accept-language");
			language = language.substring(0,2);
		}
		
		HttpSession session = request.getSession();
		
		UserDAO dao = UserDAO.getInstance();
		UserResumeVO2 ur = null;
		UserCoverLetterVO2 uc = null;
		int row = 0;
		if(session.getAttribute("user") != null) {
			UserVO vo = (UserVO)session.getAttribute("user");
			ur = dao.userResumeView(vo.getUser_num());
			if(ur == null) {
				
			}else {
				uc = dao.userCoverLetterView(vo.getUser_num(), ur.getCover_num());
				uc.setCover_contents(uc.getCover_contents().replace("\n", "<br>"));
				boolean bool=false;
				Cookie info = null;
				Cookie[] cookies = request.getCookies();
				
				for(int i=0; i<cookies.length; i++) {
					info = cookies[i];
					if(info.getName().equals("resumeList"+ur.getResume_num())) {
						bool = true;
						break;
					}
				}
				
				String newValue = ""+System.currentTimeMillis();
				if(!bool) {
					Cookie cookie = new Cookie("resumeList"+ur.getResume_num(), newValue);
					cookie.setMaxAge(60*60);
					response.addCookie(cookie);
					dao.userResumeReadcnt(ur.getResume_num());
				}
			}
			if(ur == null) {
				row = -2;
			}
		}else {
			row = -1;
		}
		System.out.println(row);
		request.setAttribute("language", language);
		request.setAttribute("row", row);
		request.setAttribute("ur", ur);
		request.setAttribute("uc", uc);
		
		RequestDispatcher rd = request.getRequestDispatcher("User/user_resume_view.jsp");
		rd.forward(request, response);
	}

}
