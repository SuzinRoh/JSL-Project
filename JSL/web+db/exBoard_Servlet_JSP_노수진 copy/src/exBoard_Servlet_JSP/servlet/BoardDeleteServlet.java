package exBoard_Servlet_JSP.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exBoard_Servlet_JSP.model.BoardDAO;

/**
 * Servlet implementation class BoardDeleteServlet
 */
@WebServlet("/BoardDelete.do")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("idx", Integer.parseInt(request.getParameter("idx")));
		request.setAttribute("page", Integer.parseInt(request.getParameter("page")));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Board/board_delete.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = BoardDAO.getInstance();
		
		int page = Integer.parseInt(request.getParameter("page"));
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		int row = dao.BoardDelete(idx);
		
		request.setAttribute("row", row);
		request.setAttribute("page", page);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Board/board_delete_pro.jsp");
		dispatcher.forward(request, response);
	}

}
