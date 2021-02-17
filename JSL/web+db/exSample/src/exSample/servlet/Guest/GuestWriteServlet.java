package exSample.servlet.Guest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exSample.model.Guest.GuestDAO;
import exSample.model.Guest.GuestVO;
import exSample.util.SHA256Util;

/**
 * Servlet implementation class GuestListWriteServlet
 */
@WebServlet("/GuestWrite.do")
public class GuestWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public GuestWriteServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int page = Integer.parseInt(request.getParameter("page"));
		
		request.setAttribute("page",page);
		
		RequestDispatcher rd = request.getRequestDispatcher("Guest/guest_write.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int page = Integer.parseInt(request.getParameter("page"));
		
		GuestDAO dao = GuestDAO.getInstance();
		GuestVO vo = new GuestVO();
		
		vo.setName(request.getParameter("name"));
		vo.setPass(request.getParameter("pass"));
		vo.setSubject(request.getParameter("subject"));
		vo.setContents(request.getParameter("contents"));
		
		
		int row = dao.GuestInsert(vo);
		
		request.setAttribute("row",row);
		request.setAttribute("page",page);
		
		RequestDispatcher rd = request.getRequestDispatcher("Guest/guest_write_pro.jsp");
		rd.forward(request, response);
	}

}
