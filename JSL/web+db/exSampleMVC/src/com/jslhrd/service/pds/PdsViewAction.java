package com.jslhrd.service.pds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.pds.PdsDAO;
import com.jslhrd.domain.pds.PdsVO;
import com.jslhrd.service.Action;

public class PdsViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PdsViewAction");
		int page = Integer.parseInt(request.getParameter("page"));
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		PdsDAO dao = PdsDAO.getInstance();
		
		boolean b = false;
		
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		for(int i=0; i< cookies.length; i++) {
			info = cookies[i];
			if(info.getName().equals("PdsCookie"+idx)) {
				b = true;
				break;
			}
		}
		String newValue = ""+System.currentTimeMillis();
		if(!b) {
			dao.pdsHits(idx);
			info = new Cookie("PdsCookie"+idx, newValue);
			info.setMaxAge(60*60);
			response.addCookie(info);
		}
		
		
		
		PdsVO vo = dao.pdsVeiw(idx);
		vo.setContents(vo.getContents().replace("\n", "<br>"));
		request.setAttribute("page", page);
		request.setAttribute("pds", vo);
		RequestDispatcher rd = request.getRequestDispatcher("Pds/pds_view.jsp");
		rd.forward(request, response);
	}

}
