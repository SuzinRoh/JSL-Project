package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GuestDAO;
import model.GuestVO;

public class GuestModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		System.out.println(idx);
		GuestDAO dao = GuestDAO.getInstance();
		GuestVO vo = new GuestVO();
		
		
		vo = dao.GuestView(idx);
		
		
		request.setAttribute("guest", vo);
		request.setAttribute("page", page);
		request.setAttribute("idx", idx);
		
		RequestDispatcher rd = request.getRequestDispatcher("Guest/guest_modify.jsp");
		rd.forward(request, response);
	}

}
