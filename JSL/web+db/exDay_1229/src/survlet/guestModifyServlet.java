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

/**
 * Servlet implementation class guestModifyServlet
 */
@WebServlet("/guest_modify")
public class guestModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public guestModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		guestDAO dao =guestDAO .getInstance();
		int idx= Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		GuestDTO guest = dao.guestSelect(idx);
		request.setAttribute("page", page);
		request.setAttribute("guest", guest);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Guest/guest_modify.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		GuestDTO guest =new GuestDTO();
		int idx=Integer.parseInt(request.getParameter("idx"));
		
		guest.setIdx(idx);
		guest.setPass(request.getParameter("pass"));
		guest.setSubject(request.getParameter("subject"));
		guest.setContents(request.getParameter("contents"));
		
		int page =Integer.parseInt(request.getParameter("page"));
		
		guestDAO dao = guestDAO.getInstance();
		
		int row =dao.guestModify(guest);
		
		/*
		 * 독립된 오류페이지 작성(디자인안되어있으면 구림)
		 * 
		if(row==1) {
			response.sendRedirect("guest_list?page="+page);
		} else {
			request.setAttribute("page", page);
			request.setAttribute("idx", idx);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Guest/error.jsp");
			dispatcher.forward(request, response);
		}
		*/
	
		request.setAttribute("page", page);
		request.setAttribute("row", row);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Guest/guest_modify_pro.jsp");
		dispatcher.forward(request, response);
		
		
		
		
		
		
	}

}
