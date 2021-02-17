package exUserServletJSTL.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exUserServletJSTL.model.UserDAO;

/**
 * Servlet implementation class UserIdcheckServlet
 */
@WebServlet("/UserIdcheck")
public class UserIdcheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserIdcheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Users/user_idcheck.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		
		UserDAO dao = UserDAO.getInstance();
		
		//id중복체크 dao메소드
		
		int row= dao.UserIdCheck(userid);
		
		request.setAttribute("row", row);
		request.setAttribute("userid", userid);
		
		RequestDispatcher rd = request.getRequestDispatcher("Users/user_idcheck.jsp");
		rd.forward(request, response);
		
		
		
	}

}
