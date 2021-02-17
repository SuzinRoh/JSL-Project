package survlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exDay_1229.model.GuestDTO;
import exDay_1229.model.guestDAO;

@WebServlet("/guest_write")
public class guestWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public guestWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		
		request.setAttribute("page", page);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Guest/guest_write.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		guestDAO dao = guestDAO.getInstance();
		GuestDTO guest = new GuestDTO();
		
		guest.setName(request.getParameter("name"));
		guest.setPass(request.getParameter("pass"));
		guest.setSubject(request.getParameter("subject"));
		guest.setContents(request.getParameter("contents"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		int row = dao.guestWrite(guest);
		
		request.setAttribute("row",row);
		request.setAttribute("page",page);
	
		//response.sendRedirect("guest_list?page="+page);//경고없이 
		
		//등록메세지 출력하고싶을
		RequestDispatcher dispatcher = request.getRequestDispatcher("Guest/guest_write_pro.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
