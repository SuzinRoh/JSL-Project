package project.service.company;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.controller.Action;
import project.domain.company.CompanyDAO;
import project.domain.user.UserCoverLetterVO2;
import project.domain.user.UserResumeVO2;
import project.domain.user.UserVO;

public class CompanyResumeView implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String language = "";
		if(request.getHeader("accept-language") != null) {
			language = request.getHeader("accept-language");
			language = language.substring(0,2);
		}
		
		int resume_num = Integer.parseInt(request.getParameter("idx"));
		
		HttpSession session = request.getSession();
		
		CompanyDAO com_dao = CompanyDAO.getInstanceof();
		UserResumeVO2 ur = null;
		UserCoverLetterVO2 uc = new UserCoverLetterVO2();
		int row = 0;
		
		if(session.getAttribute("comvo") != null) {
			ur = com_dao.userResumeView(resume_num);
			UserVO vo = com_dao.userSimple(ur.getUser_num());
			ur.setUser_name(vo.getUser_name());
			ur.setUser_email(vo.getUser_email());
			uc = com_dao.userCoverLetterView(ur.getCover_num());
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
				com_dao.userResumeReadcnt(ur.getResume_num());
			}
			
			if(ur == null) {
				row = -2;
			}
		}else {
			row = -1;
		}
		
		request.setAttribute("language", language);
		request.setAttribute("row", row);
		request.setAttribute("ur", ur);
		request.setAttribute("uc", uc);
		
		RequestDispatcher rd = request.getRequestDispatcher("Company/company_resume_view.jsp");
		rd.forward(request, response);
	}

}
