
package project.service.company;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.controller.Action;
import project.domain.company.CompanyDAO;
import project.domain.company.CompanyVO;
import project.domain.user.UserCoverLetterVO2;

public class CompanyCoverLetterView implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String language = "";
		if(request.getHeader("accept-language") != null) {
			language = request.getHeader("accept-language");
			language = language.substring(0,2);
		}
		
		int cover_num = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		HttpSession session = request.getSession();
		
		CompanyDAO dao = CompanyDAO.getInstanceof();
		UserCoverLetterVO2 ucvl = null;
		int row = 0;
		// 세션 검증 활성화
		if(session.getAttribute("comvo") != null) {
			CompanyVO vo = (CompanyVO)session.getAttribute("comvo");
			ucvl = dao.userCoverLetterView(cover_num);
				
			if(ucvl == null) {
				
				row = -2;
			}else {
				ucvl.setCover_contents(ucvl.getCover_contents().replace("\n", "<br>"));
			}
		}else {
			row = -1;
		}
		
		
		
		request.setAttribute("language", language);
		request.setAttribute("row", row);
		request.setAttribute("ucvl", ucvl);
		request.setAttribute("page", page);
		
		RequestDispatcher rd = request.getRequestDispatcher("Company/company_cover_letter_view.jsp");
		rd.forward(request, response);
	}

}
