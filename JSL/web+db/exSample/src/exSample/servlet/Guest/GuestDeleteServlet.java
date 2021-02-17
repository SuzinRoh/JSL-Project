package exSample.servlet.Guest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exSample.model.Guest.GuestDAO;

/**
 * Servlet implementation class GuestDeleteSerlvlet
 */
@WebServlet("/GuestDelete.do")
public class GuestDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		request.setAttribute("page", page);
		request.setAttribute("idx", idx);
		
		RequestDispatcher rd =request.getRequestDispatcher("Guest/guest_delete.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pass = request.getParameter("pass");
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		GuestDAO dao = GuestDAO.getInstance();
		
		int row = dao.GuestDelete(pass,idx);
		
		request.setAttribute("page", page);
		request.setAttribute("row", row);
		
		RequestDispatcher rd =request.getRequestDispatcher("Guest/guest_delete_pro.jsp");
		rd.forward(request, response);
	}

}
