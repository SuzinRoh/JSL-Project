package service.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import service.Action;

public class BoardDeleteProAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IN board_delete_pro.jsp");
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		BoardDAO dao =BoardDAO.getInstance();
		int row = dao.BoardDelete(idx);
		
		
		request.setAttribute("page",page);
		request.setAttribute("row",row);
		RequestDispatcher rd = request.getRequestDispatcher("Board/board_delete_pro.jsp");
		rd.forward(request, response);
	}
}
