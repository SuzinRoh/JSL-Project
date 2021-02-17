package service.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;
import service.Action;
import util.PageIndex;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IN board_list.jsp");
		
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = new BoardVO();
		
		String s_query ="" ,search = "", key = "";
		
		int totcount = 0;
		
		if(request.getParameter("key") != null) {
			key = request.getParameter("key");
			search = request.getParameter("search");
			s_query = search + " like '%" + key + "%' ";
		} else {
			totcount = dao.BoardListCount();
		}
		
		int nowpage = 1;
		int maxlist = 5;
		int totpage = 1;
		
		if(totcount % maxlist == 0) {
			totpage = totcount / maxlist;
		} else {
			totpage = (totcount/maxlist)+1;
		}
		
		if(request.getParameter("page") != null) {
			nowpage = Integer.parseInt(request.getParameter("page"));
		} 
		
		int startpage = (nowpage - 1) * maxlist +1 ;
		int endpage = nowpage * maxlist;
		int listcount = totcount - ((nowpage-1) * maxlist);
		
		List<BoardVO> list = null;
		String pageSkip = "" ;
		if(key.equals("")) {
			list = dao.BoardList(startpage, endpage);
			pageSkip = PageIndex.pageList(nowpage, totpage, "Board?cmd=board_list", "");
		} else {
			list = dao.BoardSearch(s_query, startpage, endpage);
			pageSkip = PageIndex.pageListHan(nowpage, totpage, "Board?cmd=board_list" , search, key);
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
		
		RequestDispatcher rd = request.getRequestDispatcher("Board/board_list.jsp");
		rd.forward(request, response);
		
	}

}
