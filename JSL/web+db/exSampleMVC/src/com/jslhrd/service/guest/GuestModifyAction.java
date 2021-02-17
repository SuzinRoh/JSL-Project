package com.jslhrd.service.guest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.guest.GuestDAO;
import com.jslhrd.domain.guest.GuestVO;
import com.jslhrd.service.Action;

public class GuestModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GuestModifyAction");
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		GuestDAO dao = GuestDAO.getInstance();
		GuestVO vo= dao.GuestView(idx);
		vo.setContents(vo.getContents().replace("\n", "<br>"));
		
		request.setAttribute("guest", vo);
		request.setAttribute("page", page);
		request.setAttribute("idx", idx);
		RequestDispatcher rd = request.getRequestDispatcher("Guest/guest_modify.jsp");
		rd.forward(request, response);
	}

}
