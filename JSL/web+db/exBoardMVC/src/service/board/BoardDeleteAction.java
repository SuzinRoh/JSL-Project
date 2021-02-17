package service.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Action;

public class BoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IN board_delete.jsp");
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		request.setAttribute("page",page);
		request.setAttribute("idx",idx);
		
		RequestDispatcher rd = request.getRequestDispatcher("Board/board_delete.jsp");
		rd.forward(request, response);
	}

}
