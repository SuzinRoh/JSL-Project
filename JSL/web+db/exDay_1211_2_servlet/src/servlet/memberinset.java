package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inset.do")
public class memberinset extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public memberinset() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		
		String[] fa = request.getParameterValues("fa");
		String tmp =fa[0];
		for(int i=1;i<fa.length;i++) {
			tmp = tmp+","+fa[i];
		}
		System.out.println(tmp);
		request.setAttribute("name",name);
		request.setAttribute("tmp",tmp);
		
		String url="/Member/userinfo_insert_pro.jsp";
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}

}
