package exBoard_Servlet_JSP.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exBoard_Servlet_JSP.model.BoardDAO;
import exBoard_Servlet_JSP.model.BoardVO;

/**
 * Servlet implementation class BoardViewSerlvet
 */
@WebServlet("/BoardView.do")
public class BoardViewSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public BoardViewSerlvet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page =Integer.parseInt(request.getParameter("page"));
		
		BoardDAO dao = BoardDAO.getInstance();
		
		boolean b = false;
		
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		for(int i=0; i< cookies.length; i++) {
			info = cookies[i];
			if(info.getName().equals("BoardCookie"+idx)) {
				b = true;
				break;
			}
		}
		String newValue = ""+System.currentTimeMillis();
		if(!b) {
			dao.BoardHits(idx);
			info = new Cookie("BoardCookie"+idx, newValue);
			info.setMaxAge(60*60);
			response.addCookie(info);
		}
		
	
		BoardVO vo = dao.BoardList(idx);
		
		request.setAttribute("idx", idx);
		request.setAttribute("page", page);
		request.setAttribute("vo", vo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Board/board_view.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
