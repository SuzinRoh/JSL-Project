package com.jslhrd.service.admin.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.service.Action;

public class AdminNoticeWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AdminNoticeWriteAction");
		int page = Integer.parseInt(request.getParameter("page"));
		
		
		request.setAttribute("page", page);
		RequestDispatcher rd = request.getRequestDispatcher("Admin/notice_write.jsp");
		rd.forward(request, response);
	}

}
