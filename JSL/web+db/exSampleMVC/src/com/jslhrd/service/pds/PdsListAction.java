package com.jslhrd.service.pds;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.pds.PdsDAO;
import com.jslhrd.domain.pds.PdsVO;
import com.jslhrd.service.Action;
import com.jslhrd.util.PageIndex;

public class PdsListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PdsListAction");
		
		PdsDAO dao = PdsDAO.getInstance();
		String s_query = "" , search = "" , key ="";
		
		int totcount = 0;
		
		if(request.getParameter("key") !=null) {
			key = request.getParameter("key");
			search = request.getParameter("search");
			s_query = search + " like '%" + key + "%' ";
			totcount = dao.pdsSearchCount(s_query);
		} else {
			totcount = dao.pdsCount();
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
		
		
		List<PdsVO> list = null;
		String pageSkip ="";
		if(key.equals("")) {
			list = dao.pdsList(startpage, endpage);
			pageSkip = PageIndex.pageList(nowpage, totpage, "Pds?cmd=pds_list" , "");
		} else {
			list = dao.pdsSearch(s_query, startpage, endpage);
			pageSkip = PageIndex.pageListHan(nowpage, totpage, "Pds?cmd=pds_list" , search, key);
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
		
		RequestDispatcher rd = request.getRequestDispatcher("Pds/pds_list.jsp");
		rd.forward(request, response);
	}

}
