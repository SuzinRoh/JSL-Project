package com.jslhrd.service.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.board.BoardDAO;
import com.jslhrd.domain.board.BoardVO;
import com.jslhrd.service.Action;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BoardViewAction");
		int page = Integer.parseInt(request.getParameter("page"));
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		BoardDAO dao = BoardDAO.getInstance();
		
		boolean b = false;
		
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		for(int i=0; i< cookies.length; i++) {
			info = cookies[i];
			if(info.getName().equals("BoardCookie"+idx)) {
				b = true;
				break;
			}
		}
		String newValue = ""+System.currentTimeMillis();
		if(!b) {
			dao.BoardHits(idx);
			info = new Cookie("BoardCookie"+idx, newValue);
			info.setMaxAge(60*60);
			response.addCookie(info);
		}
		
		
		
		BoardVO vo = dao.BoardView(idx);
		vo.setContents(vo.getContents().replace("\n", "<br>"));
		request.setAttribute("idx", idx);
		request.setAttribute("page", page);
		request.setAttribute("board", vo);
		RequestDispatcher rd = request.getRequestDispatcher("Board/board_view.jsp");
		rd.forward(request, response);
	}

}
