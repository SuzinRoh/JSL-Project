package exBoard_Servlet_JSP.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exBoard_Servlet_JSP.model.BoardDAO;
import exBoard_Servlet_JSP.model.BoardVO;
import exBoard_Servlet_JSP.util.PageIndex;


@WebServlet("/BoardList.do")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		BoardDAO dao = BoardDAO.getInstance();
		String s_query="", search ="" , key ="";
		
		int totcount =0;
		
		
		if(request.getParameter("key") !=null) {
			key = request.getParameter("key");
			search = request.getParameter("search");
			s_query = search + " like '%" + key + "%' ";
			totcount = dao.BoardSearchCount(s_query);
		} else {
			totcount = dao.BoardListCount();
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
		
		
		List<BoardVO> list = null;
		if(key.equals("")) {
			list = dao.BoardList(startpage, endpage);
		} else {
			list = dao.BoardSearch(s_query,startpage,endpage);
		}
		
		
		String pageSkip ="";
		if(key.equals("")) {
			pageSkip = PageIndex.pageList(nowpage, totpage, "BoardList.do" , "");
		} else {
			pageSkip = PageIndex.pageListHan(nowpage, totpage, "BoardList.do" , search, key);
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
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Board/board_list.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
