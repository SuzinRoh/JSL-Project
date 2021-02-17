package service.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;
import service.Action;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IN board_view.jsp");
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = dao.BoardList(idx);
		vo.setContents(vo.getContents().replace("\n", "<br>"));
		request.setAttribute("page", page);
		request.setAttribute("idx", idx);
		request.setAttribute("board", vo);
		RequestDispatcher rd = request.getRequestDispatcher("Board/board_view.jsp");
		rd.forward(request, response);
	}

}
