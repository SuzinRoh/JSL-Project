package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user_insert.do")
public class userinsertservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public userinsertservlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "Users/user_insert.jsp";
		
		RequestDispatcher rd= request.getRequestDispatcher(url);
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		//System.out.println("name :"+name);
		//process
		
		int row=1;//result
		request.setAttribute("name", name);
		request.setAttribute("row", row);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Users/user_insert_pro.jsp");
		rd.forward(request, response);
	}

}
