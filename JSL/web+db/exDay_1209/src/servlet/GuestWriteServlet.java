package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/write")
public class GuestWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GuestWriteServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd =request.getRequestDispatcher("/Guest/guest_write.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String contents = request.getParameter("contents");
		
		// db 
		
		int row = 1;
		request.setAttribute("row", row);
		request.setAttribute("name", name);
		request.setAttribute("subject", subject);
		request.setAttribute("contents", contents);
		
		response.sendRedirect("/Guest/guest_write_pro.jsp?row="+row);
		//RequestDispatcher rd =request.getRequestDispatcher("/Guest/guest_write_pro.jsp");
		//rd.forward(request, response);
	}

}
