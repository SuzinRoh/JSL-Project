package project.service.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.controller.Action;
import project.domain.company.CompanyDAO;
import project.domain.company.CompanyVO;

public class MainAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		CompanyDAO dao = CompanyDAO.getInstanceof();
		List<CompanyVO> list = dao.companyListJoin();
		
		for(CompanyVO vo :list) {
			System.out.println(vo.getCom_num());
		}
		
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("Main/index.jsp");
		rd.forward(request, response);
	}

}
