package com.jslhrd.service.admin.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.admin.adminNoticeDAO;
import com.jslhrd.domain.admin.adminNoticeVO;
import com.jslhrd.domain.guest.GuestVO;
import com.jslhrd.service.Action;

public class AdminNoticeModifyProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AdminModifyProAction");
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		System.out.println(idx);
		System.out.println(page);
		
		adminNoticeDAO dao = adminNoticeDAO.getInstance();
		
		
		String sub = request.getParameter("subject");
		String con = request.getParameter("contents");
		String pass = request.getParameter("pass");
	
		int row = dao.NoticeModify(sub, con, idx, pass);
		
		
		request.setAttribute("row", row);
		request.setAttribute("page", page);
		RequestDispatcher rd = request.getRequestDispatcher("Admin/notice_modify_pro.jsp");
		rd.forward(request, response);

	}

}
