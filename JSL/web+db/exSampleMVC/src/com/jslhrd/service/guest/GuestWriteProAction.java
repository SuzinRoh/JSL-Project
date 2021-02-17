package com.jslhrd.service.guest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.board.BoardVO;
import com.jslhrd.domain.guest.GuestDAO;
import com.jslhrd.domain.guest.GuestVO;
import com.jslhrd.service.Action;

public class GuestWriteProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GuestWrtieProAction");
		int page = Integer.parseInt(request.getParameter("page"));
		
		GuestDAO dao = GuestDAO.getInstance();
		GuestVO vo = new GuestVO();
		
		vo.setName(request.getParameter("name"));
		vo.setSubject(request.getParameter("subject"));
		vo.setContents(request.getParameter("contents"));
		vo.setPass(request.getParameter("pass"));
		
		int row = dao.GuestInsert(vo);
		request.setAttribute("row", row);
		request.setAttribute("page", page);
		RequestDispatcher rd = request.getRequestDispatcher("Guest/guest_write_pro.jsp");
		rd.forward(request, response);

	}

}
