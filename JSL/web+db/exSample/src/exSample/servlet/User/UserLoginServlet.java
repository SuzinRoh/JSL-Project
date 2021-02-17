package exSample.servlet.User;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exSample.model.User.UserDAO;
import exSample.model.User.UserVO;
import exSample.util.SHA256Util;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLogin.do")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("Users/user_login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("userid");
		String passwd = SHA256Util.getEncSHA256(request.getParameter("passwd"));
		
		UserDAO dao = UserDAO.getInstance();
		
		
		int row = dao.UserIdCheck(id, passwd);//1성 0비번오류 -1아이디오류
		if(row == 1) {
			UserVO vo = dao.UserSelect(id);
			HttpSession session = request.getSession();//세션객체생성
			
			session.setAttribute("loginuser", vo);
			session.setMaxInactiveInterval(1800);//유지시간 30bun
		}
		
		request.setAttribute("userid", id);
		request.setAttribute("row", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("Users/userlogin_ok.jsp");
		rd.forward(request, response);
	}

}
