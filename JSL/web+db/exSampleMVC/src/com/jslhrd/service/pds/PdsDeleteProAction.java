package com.jslhrd.service.pds;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.pds.PdsDAO;
import com.jslhrd.service.Action;

public class PdsDeleteProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PdsdeleteproAction");
		
		int page = Integer.parseInt(request.getParameter("page"));
		int idx = Integer.parseInt(request.getParameter("idx"));
		String pass = request.getParameter("pass");
		
		
		PdsDAO dao = PdsDAO.getInstance();
		String filename = dao.getFile(idx);
		int row= dao.pdsDelete(idx, pass);
		
		if(row==1) {
			ServletContext sc = request.getSession().getServletContext();
			String path = sc.getRealPath("Pds/upload/");
			File file =new File(path+filename);
			if(file.exists()) {
				file.delete();
			}
		}
		
		request.setAttribute("row", row);
		request.setAttribute("page", page);
		RequestDispatcher rd = request.getRequestDispatcher("Pds/pds_delete_pro.jsp");
		rd.forward(request, response);
	}

}
