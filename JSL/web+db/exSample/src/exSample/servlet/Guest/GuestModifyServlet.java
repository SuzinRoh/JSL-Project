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

/**
 * Servlet implementation class GuestModifyServlet
 */
@WebServlet("/GuestModify.do")
public class GuestModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int page = Integer.parseInt(request.getParameter("page"));
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		GuestDAO dao = GuestDAO.getInstance();
		
		GuestVO vo = dao.GuestView(idx);
		
		vo.setContents(vo.getContents().replace("\n", "<br>"));
		request.setAttribute("page", page);
		request.setAttribute("vo", vo);
		request.setAttribute("idx", idx);
		
		RequestDispatcher rd = request.getRequestDispatcher("Guest/guest_modify.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int page = Integer.parseInt(request.getParameter("page"));
		int idx = Integer.parseInt(request.getParameter("idx"));
		GuestDAO dao = GuestDAO.getInstance();
		GuestVO vo =new GuestVO();
		
		vo.setIdx(Integer.parseInt(request.getParameter("idx")));
		vo.setSubject(request.getParameter("subject"));
		vo.setPass(request.getParameter("passwd"));
		vo.setContents(request.getParameter("contents"));
		System.out.println(idx);
		System.out.println(request.getParameter("subject"));
		System.out.println(request.getParameter("passwd"));
		System.out.println(request.getParameter("contents"));
		int row = dao.GuestModify(vo);
		
		request.setAttribute("page", page);
		request.setAttribute("row", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("Guest/guest_modify_pro.jsp");
		rd.forward(request, response);
	}

}
