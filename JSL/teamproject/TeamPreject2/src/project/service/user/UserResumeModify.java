package project.service.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.controller.Action;
import project.domain.user.UserCoverLetterVO2;
import project.domain.user.UserDAO;
import project.domain.user.UserResumeVO2;
import project.domain.user.UserVO;

public class UserResumeModify implements Action {

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
		List<String> flist = new ArrayList<String>();
		List<String> clist = new ArrayList<String>();
		UserCoverLetterVO2 uc = new UserCoverLetterVO2();
		int row = 0;
		if(session.getAttribute("user") != null) {
			UserVO vo = (UserVO)session.getAttribute("user");
			ur = dao.userResumeView(vo.getUser_num());
			uc = dao.userCoverLetterView(ur.getUser_num(), ur.getCover_num());
			if(ur.getResume_foreign_language() != null) {
				String[] str = ur.getResume_foreign_language().split(",");
				for(String temp : str) {
					flist.add(temp);
				}
			}
			if(ur.getResume_certification() != null) {
				String[] str = ur.getResume_certification().split(",");
				for(String temp : str) {
					clist.add(temp);
				}
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
		request.setAttribute("flist", flist);
		request.setAttribute("clist", clist);
		request.setAttribute("uc", uc);
		
		RequestDispatcher rd = request.getRequestDispatcher("User/user_resume_modify.jsp");
		rd.forward(request, response);
	}

}
