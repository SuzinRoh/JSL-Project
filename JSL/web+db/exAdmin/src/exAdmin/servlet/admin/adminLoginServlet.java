package exAdmin.servlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class adminServlet
 */
@WebServlet("/adminLogin.do")
public class adminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Admin/adminLoginok.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("adminid");
		String pw =request.getParameter("adminpass");
		int row =0;
		if(id.equals("1234") && pw.equals("1234")) {
			
			HttpSession sess = request.getSession();
			
			sess.setAttribute("admin", id);
			sess.setMaxInactiveInterval(1800);
			
			row=1;
			
		} 
		
	
		request.setAttribute("row", row);
		RequestDispatcher rd = request.getRequestDispatcher("/Admin/index_pro.jsp");
		rd.forward(request, response);
		
		
		
	}

}
