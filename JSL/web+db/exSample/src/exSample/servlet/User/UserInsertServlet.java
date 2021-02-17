package exSample.servlet.User;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exSample.model.User.UserDAO;
import exSample.model.User.UserVO;
import exSample.util.SHA256Util;

/**
 * Servlet implementation class UserInsertServlet
 */
@WebServlet("/UserInsert.do")
public class UserInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Users/user_insert.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		UserDAO dao = UserDAO.getInstance();
		UserVO vo = new UserVO();
		
		vo.setName(request.getParameter("name"));
		vo.setUserid(request.getParameter("userid"));
		vo.setPasswd(SHA256Util.getEncSHA256(request.getParameter("passwd")));
		vo.setTel(request.getParameter("tel"));
		String email="";
		if(!request.getParameter("email2").equals("")) {
			email = request.getParameter("email1")+"@"+request.getParameter("email2");
		} else {
			email = request.getParameter("email1")+"@"+request.getParameter("email3");
		}
		vo.setEmail(email);
		
		int row = dao.UserInsert(vo);
		
		request.setAttribute("row", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("Users/user_insert_pro.jsp");
		rd.forward(request, response);
	}

}
