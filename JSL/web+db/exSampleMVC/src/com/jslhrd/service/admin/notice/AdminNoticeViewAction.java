package com.jslhrd.service.admin.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.admin.adminNoticeDAO;
import com.jslhrd.domain.admin.adminNoticeVO;
import com.jslhrd.service.Action;

public class AdminNoticeViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AdminNoticeViewAction");
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));

	
		adminNoticeDAO dao = adminNoticeDAO.getInstance();

		boolean b = false;

		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			info = cookies[i];
			if (info.getName().equals("NoticeCookie" + idx)) {
				b = true;
				break;
			}
		}
		String newValue = "" + System.currentTimeMillis();
		if (!b) {
			dao.NoticeHits(idx);
			info = new Cookie("NoticeCookie" + idx, newValue);
			info.setMaxAge(60 * 60);
			response.addCookie(info);
		}

		adminNoticeVO vo = dao.noticeSelect(idx);
		
		vo.setContents(vo.getContents().replace("\n", "<br>"));
		
		request.setAttribute("idx", idx);
		request.setAttribute("page", page);
		request.setAttribute("notice", vo);
		
		RequestDispatcher rd = request.getRequestDispatcher("Admin/notice_view.jsp");
		rd.forward(request, response);
	}

}
