package exUserServletJSTL.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exUserServletJSTL.model.UserDAO;

@WebServlet("/UserModify")
public class UserModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UserModifyServlet() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*세션이 없을경우
		 * UserDAO dao = UserDAO.getInstance();
		String userid = request.getParameter("userid");
		UserVO vo = dao.UserSelect(userid);
		request.setAttribute("user", vo);
		*/
		
		/*세션설정값을 이용하는 경우
		 * HttpSession session = request.getSession();
		UserVO vo = (UserVO) session.getAttribute("user");
		request.setAttribute("user", vo);
		*/
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Users/user_modify.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDAO dao = UserDAO.getInstance();
		String id = request.getParameter("userid");
		String passwd = request.getParameter("newpasswd");
		
		int row = dao.UserModify(id,passwd);
		
		request.setAttribute("row", row);
		RequestDispatcher rd = request.getRequestDispatcher("Users/user_modify_pro.jsp");
		rd.forward(request, response);
		
		
	}

}
