package project.service.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.controller.Action;
import project.domain.company.CompanyDAO;
import project.domain.company.CompanyVO;
import project.domain.user.UserDAO;
import project.domain.user.UserResumeVO2;
import project.domain.user.UserVO;
import project.util.PageIndex;

public class CompanyResumeList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UserDAO dao = UserDAO.getInstance();
		CompanyDAO com_dao = CompanyDAO.getInstanceof();
		
		int totcount = 0;
		
		HttpSession session = request.getSession();
		
		CompanyVO com_vo = null;
		if(session.getAttribute("comvo") != null) {
			totcount = com_dao.userResumeCount();
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
		
		List<UserResumeVO2> list_temp = null;
		List<UserResumeVO2> list = new ArrayList<UserResumeVO2>();
		//기업 세션 확인되면 리스트 보여줌
		if(session.getAttribute("comvo") != null) {
			list_temp = com_dao.userResumeList(startpage, endpage);
			Iterator<UserResumeVO2> iter = list_temp.iterator();
			while(iter.hasNext()) {
				UserResumeVO2 ur = iter.next();
				UserVO vo = com_dao.userSimple(ur.getUser_num());
				ur.setUser_name(vo.getUser_name());
				list.add(ur);
			}
		}
		
		list_temp = com_dao.userResumeList(startpage, endpage);
		
		String pageSkip = "";
		pageSkip = PageIndex.pageList(nowpage, totpage, "Company?cmd=company_resume_list", "");
		
		request.setAttribute("totcount", totcount);
		request.setAttribute("totpage", totpage);
		request.setAttribute("page", nowpage);
		request.setAttribute("listcount", listcount);
		request.setAttribute("list", list);
		request.setAttribute("pageSkip", pageSkip);
		
		RequestDispatcher rd = request.getRequestDispatcher("Company/company_resume_list.jsp");
		rd.forward(request, response);

	}

}
