package com.jslhrd.service.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.admin.adminNoticeDAO;
import com.jslhrd.domain.admin.adminNoticeVO;
import com.jslhrd.domain.board.BoardDAO;
import com.jslhrd.domain.board.BoardVO;
import com.jslhrd.domain.guest.GuestDAO;
import com.jslhrd.domain.guest.GuestVO;
import com.jslhrd.domain.pds.PdsDAO;
import com.jslhrd.domain.pds.PdsVO;
import com.jslhrd.service.Action;

public class MainAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("MainAction");
		
		PdsDAO pdsDao = PdsDAO.getInstance();
		GuestDAO guestDao = GuestDAO.getInstance();
		BoardDAO boardDao = BoardDAO.getInstance();
		adminNoticeDAO noticeDao = adminNoticeDAO.getInstance();
		
		List<PdsVO> pdsList = pdsDao.PdsSelectMain();
		List<adminNoticeVO> noticeList = noticeDao.adminNoticeSelectMain();
		List<GuestVO> guestList = guestDao.GuestSelectMain();
		List<BoardVO> boardList = boardDao.BoardSelectMain();
		
		request.setAttribute("guestList", guestList);
		request.setAttribute("boardList", boardList);
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("pdsList", pdsList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Main/index.jsp");
		rd.forward(request, response);
	}

}
