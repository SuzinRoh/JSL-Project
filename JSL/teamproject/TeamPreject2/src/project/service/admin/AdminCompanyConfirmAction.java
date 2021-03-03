package project.service.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.controller.Action;
import project.domain.admin.AdminDAO;
import project.domain.company.CompanyVO;

public class AdminCompanyConfirmAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String language = "";
		if(request.getHeader("accept-language")!=null) {
			language = request.getHeader("accept-language");
		}
		language = language.substring(0,2);
		request.setAttribute("language", language);
		
		//관리자가 미승인한 기업을 리스트로 불러옵니다.
		AdminDAO dao = AdminDAO.getInstanceof();
		List<CompanyVO> list = dao.company_not_confirmed_list();
		request.setAttribute("list", list);
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Admin/admin_confirm.jsp");
		rd.forward(request, response);
		
	}

}
