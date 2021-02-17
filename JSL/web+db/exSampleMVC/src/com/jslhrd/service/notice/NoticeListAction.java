package com.jslhrd.service.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.notice.NoticeDAO;
import com.jslhrd.domain.notice.NoticeVO;
import com.jslhrd.service.Action;
import com.jslhrd.util.PageIndex;

public class NoticeListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("NoticeListAction");
		

		NoticeDAO dao = NoticeDAO.getInstance();
		String s_query = "" , search = "" , key ="";
		
		int totcount = 0;
		
		if(request.getParameter("key") !=null) {
			key = request.getParameter("key");
			search = request.getParameter("search");
			s_query = search + " like '%" + key + "%' ";
			totcount = dao.NoticeSearchCount(s_query);
		} else {
			totcount = dao.NoticeListCount();
		}
		
		int nowpage= 1;
		int maxlist= 10;
		int totpage =1;
		
		if(totcount % maxlist ==0) {
			totpage = totcount/maxlist;
		} else {
			totpage = (totcount/maxlist)+1;
		}
		
		
		if(request.getParameter("page") != null) {
			nowpage = Integer.parseInt(request.getParameter("page"));
		}
		
		int startpage = (nowpage-1) * maxlist+1;
		int endpage = nowpage * maxlist;
		int listcount = totcount-((nowpage-1)*maxlist);
		
		
		List<NoticeVO> list = null;
		String pageSkip ="";
		if(key.equals("")) {
			list = dao.NoticeList(startpage, endpage);
			pageSkip = PageIndex.pageList(nowpage, totpage, "Notice?cmd=notice_list" , "");
		} else {
			list = dao.NoticeSearch(s_query, startpage, endpage);
			pageSkip = PageIndex.pageListHan(nowpage, totpage, "Notice?cmd=notice_list" , search, key);
		}
		
	
		
		
		
		request.setAttribute("page", nowpage);
		request.setAttribute("totpage", totpage);
		request.setAttribute("totcount", totcount);
		request.setAttribute("listcount", listcount);
		request.setAttribute("pageSkip", pageSkip);
		request.setAttribute("page", nowpage);
		request.setAttribute("list", list);
		request.setAttribute("search", search);
		request.setAttribute("key", key);
		
		RequestDispatcher rd= request.getRequestDispatcher("Notice/notice_list.jsp");
		rd.forward(request, response);
	}

}
