package project.service.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.controller.Action;
import project.domain.admin.AdminDAO;

public class AdminCompanyConfirmProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String language = "";
		if(request.getHeader("accept-language")!=null) {
			language = request.getHeader("accept-language");
		}
		language = language.substring(0,2);
		request.setAttribute("language", language);
		AdminDAO dao = AdminDAO.getInstanceof();
		int row = 0;
		
		String com_id = request.getParameter("idx");
		String[] arrIdx = com_id.toString().split(",");
		for (int i=0; i<arrIdx.length; i++) {
			int tempIdx = Integer.parseInt(arrIdx[i]);
			row = dao.AdminConfirm(tempIdx);
		}
		
		request.setAttribute("row", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("Admin/admin_confirm_pro.jsp");
		rd.forward(request, response);
		
	}

}
