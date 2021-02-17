package com.jslhrd.service.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.board.BoardDAO;
import com.jslhrd.domain.board.BoardVO;
import com.jslhrd.service.Action;

public class BoardModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BoardModifyAction");
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo= dao.BoardView(idx);
		vo.setContents(vo.getContents().replace("\n", "<br>"));
		
		request.setAttribute("board", vo);
		request.setAttribute("page", page);
		RequestDispatcher rd = request.getRequestDispatcher("Board/board_modify.jsp");
		rd.forward(request, response);
	}

}
