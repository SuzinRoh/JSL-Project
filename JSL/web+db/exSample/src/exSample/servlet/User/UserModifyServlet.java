package exSample.servlet.User;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exSample.model.User.UserDAO;
import exSample.util.SHA256Util;

/**
 * Servlet implementation class UserModifyServlet
 */
@WebServlet("/UserModify.do")
public class UserModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UserModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("Users/user_modify.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String beforepw = SHA256Util.getEncSHA256(request.getParameter("beforepw"));
		String passwd = SHA256Util.getEncSHA256(request.getParameter("passwd"));
		UserDAO dao = UserDAO.getInstance();
		
		int row = dao.UserModify(beforepw,passwd,userid);
		request.setAttribute("row", row);
		RequestDispatcher rd = request.getRequestDispatcher("Users/user_modify_pro.jsp");
		rd.forward(request, response);
	}

}
