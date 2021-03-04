package project.service.company;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.controller.Action;
import project.domain.company.CompanyDAO;
import project.domain.company.CompanyVO;

public class CompanyInfomationAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("company infomation action");
		// /Company?cmd=company_infomation
        CompanyVO vo = new CompanyVO();
        CompanyDAO dao = CompanyDAO.getInstanceof();

        int num = Integer.parseInt(request.getParameter("com_num"));

        vo = dao.companyInfomation(num);

		request.setAttribute("vo", vo);
		RequestDispatcher rd = request.getRequestDispatcher("/Company/company_info.jsp");
		rd.forward(request, response);
	}

}
