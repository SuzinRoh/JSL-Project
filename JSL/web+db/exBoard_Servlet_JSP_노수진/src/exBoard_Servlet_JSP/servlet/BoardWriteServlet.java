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

/**
 * Servlet implementation class BoardWriteServlet
 */
@WebServlet("/BoardWrite.do")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    public BoardWriteServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("page", Integer.parseInt(request.getParameter("page")));
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Board/board_write.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = new BoardVO();
		

		int page = Integer.parseInt(request.getParameter("page"));
		vo.setPass(request.getParameter("pass"));
		vo.setName(request.getParameter("name"));
		vo.setEmail(request.getParameter("email"));
		vo.setSubject(request.getParameter("subject"));
		vo.setContents(request.getParameter("contents"));
		vo.setIp(request.getRemoteAddr());
		
		int row = dao.BoardWrite(vo);
		
		request.setAttribute("row", row);
		request.setAttribute("page", page);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Board/board_write_pro.jsp");
		dispatcher.forward(request, response);
		
	}

}
