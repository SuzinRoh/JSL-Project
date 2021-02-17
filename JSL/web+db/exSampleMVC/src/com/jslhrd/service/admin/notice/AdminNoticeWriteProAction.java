package com.jslhrd.service.admin.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.admin.adminNoticeDAO;
import com.jslhrd.domain.admin.adminNoticeVO;
import com.jslhrd.service.Action;

public class AdminNoticeWriteProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AdminNoticeWrtieProAction");
		int page = Integer.parseInt(request.getParameter("page"));
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		adminNoticeDAO dao = adminNoticeDAO.getInstance();
		adminNoticeVO vo = new adminNoticeVO();
		
		
		vo.setSubject(request.getParameter("subject"));
		vo.setContents(request.getParameter("contents"));
		vo.setPass(request.getParameter("pass"));
		
		int row = dao.noticeWrite(vo);
		request.setAttribute("row", row);
		request.setAttribute("page", page);
		RequestDispatcher rd = request.getRequestDispatcher("Admin/notice_write_pro.jsp");
		rd.forward(request, response);

	}

}
