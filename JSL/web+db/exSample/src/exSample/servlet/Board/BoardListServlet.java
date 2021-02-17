package exSample.servlet.Board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exSample.model.Board.BoardDAO;
import exSample.model.Board.BoardVO;
import exSample.model.Guest.GuestVO;
import exSample.util.PageIndex;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/BoardList.do")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = new BoardVO();
		String searchQuery = "" , search = "", key = "" ;
		
		int totcount = 0;
		
		
		if(request.getParameter("key") != null ) {
			key = request.getParameter("key");
			search = request.getParameter("search");
			searchQuery = search + " like '%" + key +"%' ";
			totcount = dao.BoardSearchCount(searchQuery);
		} else {
			totcount = dao.BoardListCount();
		}
		
		
		int nowpage = 1;
		int maxlist = 10;
		int totpage = 1;
		
		
		if(totcount % maxlist == 0) {
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
			list =dao.BoardSelect(startpage, endpage);
		} else {
			list =dao.BoardSearch(searchQuery,startpage,endpage);
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
		
		RequestDispatcher rd = request.getRequestDispatcher("Board/board_list.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
