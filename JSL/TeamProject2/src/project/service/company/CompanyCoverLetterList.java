package project.service.company;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.controller.Action;
import project.domain.company.CompanyDAO;
import project.domain.company.CompanyVO;
import project.domain.user.UserCoverLetterVO2;
import project.domain.user.UserDAO;
import project.util.PageIndex;

public class CompanyCoverLetterList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UserDAO dao = UserDAO.getInstance();
		CompanyDAO com_dao = CompanyDAO.getInstanceof();
		
		int totcount = 0;
		
		HttpSession session = request.getSession();
		
		CompanyVO vo = null;
		
		
		if(session.getAttribute("comvo") != null) {
			totcount = com_dao.userCoverLetterCount();
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
		
		//기업 세션 확인되면 리스트 보여줌
		if(session.getAttribute("comvo") != null) {
			list = com_dao.userCoverLetterList(startpage, endpage);
		}
		
		String pageSkip = "";
		pageSkip = PageIndex.pageList(nowpage, totpage, "Company?cmd=company_cover_letter_list", "");
		
		// 기능 사용 보류
		request.setAttribute("totcount", totcount);
		request.setAttribute("totpage", totpage);
		request.setAttribute("page", nowpage);
		request.setAttribute("listcount", listcount);
		request.setAttribute("list", list);
		request.setAttribute("pageSkip", pageSkip);
		
		RequestDispatcher rd = request.getRequestDispatcher("Company/company_cover_letter_list.jsp");
		rd.forward(request, response);

	}

}
