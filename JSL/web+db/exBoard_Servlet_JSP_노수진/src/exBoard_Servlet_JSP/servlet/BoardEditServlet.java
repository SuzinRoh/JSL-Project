package exBoard_Servlet_JSP.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exBoard_Servlet_JSP.model.BoardDAO;
import exBoard_Servlet_JSP.model.BoardVO;

@WebServlet("/BoardEdit.do")
public class BoardEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public BoardEditServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		request.setAttribute("page", Integer.parseInt(request.getParameter("page")));
		request.setAttribute("idx", idx);
		
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = dao.BoardList(idx);
		
		request.setAttribute("vo", vo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Board/board_modify.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = new BoardVO();
		
		int page = Integer.parseInt(request.getParameter("page"));
		vo.setIdx(Integer.parseInt(request.getParameter("idx")));
		vo.setPass(request.getParameter("pass"));
		vo.setEmail(request.getParameter("email"));
		vo.setSubject(request.getParameter("subject"));
		vo.setContents(request.getParameter("contents"));
	
		int row = dao.BoardEdit(vo);
		
		request.setAttribute("row", row);
		request.setAttribute("page", page);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Board/board_modify_pro.jsp");
		dispatcher.forward(request, response);
		
	}

}
