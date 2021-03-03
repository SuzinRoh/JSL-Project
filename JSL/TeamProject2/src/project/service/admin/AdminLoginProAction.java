package project.service.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.controller.Action;
import project.domain.admin.AdminDAO;
import project.domain.admin.AdminVO;

public class AdminLoginProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String language = "";
		if(request.getHeader("accept-language")!=null) {
			language = request.getHeader("accept-language");
		}
		language = language.substring(0,2);
		request.setAttribute("language", language);
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		
		AdminDAO dao = AdminDAO.getInstanceof();
		int row = 0;
		row = dao.AdminLogin(id,pass);
		
		if(row==1) {
			HttpSession session = request.getSession();
			AdminVO admin = dao.AdminSelect(id, pass);
			session.setMaxInactiveInterval(1800);
			session.setAttribute("admin", admin);
		}
		
		request.setAttribute("row", row);
		
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Admin/admin_login_pro.jsp");
		rd.forward(request, response);
	}

}
