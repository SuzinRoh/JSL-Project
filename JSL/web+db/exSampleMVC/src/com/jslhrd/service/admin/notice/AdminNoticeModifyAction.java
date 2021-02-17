package com.jslhrd.service.admin.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.admin.adminNoticeDAO;
import com.jslhrd.domain.admin.adminNoticeVO;
import com.jslhrd.service.Action;

public class AdminNoticeModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AdminNoticeModifyAction");
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		System.out.println(idx);
		System.out.println(page);
		
		adminNoticeDAO dao = adminNoticeDAO.getInstance();
		
		adminNoticeVO vo = dao.noticeSelect(idx);
		vo.setContents(vo.getContents().replace("\n", "<br>"));
		
		request.setAttribute("idx", idx);
		request.setAttribute("page", page);
		request.setAttribute("notice", vo);
		RequestDispatcher rd = request.getRequestDispatcher("Admin/notice_modify.jsp");
		rd.forward(request, response);
	}

}
