package com.jslhrd.service.pds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.pds.PdsDAO;
import com.jslhrd.domain.pds.PdsVO;
import com.jslhrd.service.Action;

public class PdsModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("pdsModifyAction");
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		PdsDAO dao = PdsDAO.getInstance();
		PdsVO vo= dao.pdsVeiw(idx);
		vo.setContents(vo.getContents().replace("\n", "<br>"));
		
		request.setAttribute("pds", vo);
		request.setAttribute("page", page);
		request.setAttribute("idx", idx);
		RequestDispatcher rd = request.getRequestDispatcher("Pds/pds_modify.jsp");
		rd.forward(request, response);
	}

}
