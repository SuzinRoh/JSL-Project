package com.jslhrd.service.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.notice.NoticeDAO;
import com.jslhrd.domain.notice.NoticeVO;
import com.jslhrd.service.Action;

public class NoticeViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("NoticeViewAction");
		
		int page = Integer.parseInt(request.getParameter("page"));
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		NoticeDAO dao = NoticeDAO.getInstance();
		
		boolean b = false;
		
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		for(int i=0; i< cookies.length; i++) {
			info = cookies[i];
			if(info.getName().equals("NoticeCookie"+idx)) {
				b = true;
				break;
			}
		}
		String newValue = ""+System.currentTimeMillis();
		if(!b) {
			dao.NoticeHits(idx);
			info = new Cookie("NoticeCookie"+idx, newValue);
			info.setMaxAge(60*60);
			response.addCookie(info);
		}
		
		
		
		NoticeVO vo = dao.noticeSelect(idx);
		vo.setContents(vo.getContents().replace("\n", "<br>"));
		request.setAttribute("page", page);
		request.setAttribute("notice", vo);
		RequestDispatcher rd = request.getRequestDispatcher("Notice/notice_view.jsp");
		rd.forward(request, response);
	}

}
