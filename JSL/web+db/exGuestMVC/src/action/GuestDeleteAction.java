package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GuestDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		
		request.setAttribute("idx", idx);
		request.setAttribute("page", page);
		
		RequestDispatcher rd = request.getRequestDispatcher("Guest/guest_delete.jsp");
		rd.forward(request, response);
	}

}
