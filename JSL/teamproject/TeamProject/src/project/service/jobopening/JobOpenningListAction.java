package project.service.jobopening;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.controller.Action;
import project.domain.company.CompanyDAO;
import project.domain.company.CompanyVO;
import project.domain.jobopening.JobOpeningDAO;

public class JobOpenningListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = "" , s_query = "", search = "";
		CompanyDAO dao = CompanyDAO.getInstanceof();
		JobOpeningDAO j_dao = JobOpeningDAO.getInstanceof();
		int count = j_dao.countjobOpening();
		if(request.getParameter("key") != null) {
			key = request.getParameter("key");
			count = j_dao.countjobOpening(key);
			if(request.getParameter("searchwhat")!= null) {
				search = request.getParameter("searchwhat");
				s_query = search +" like '%"+ key +"%'";
			}else {
				s_query="opening_subject like '%"+ key +"%'"; // 이건 메인에서 들어올떄 searchwhat값이 없기떄문에 사용하였습니다.
			}
		}
		int nowpage = 1;
		int maxlist = 10;
		int totpage = 1;
		
		if(totpage % maxlist == 0) {
			totpage = count / maxlist;
		}else {
			totpage = count / maxlist + 1;
		}
		
		int startpage = (nowpage-1) * maxlist + 1;
		int endpage = nowpage * maxlist;
		int listcount = count -((nowpage-1)*maxlist);
		
		
		
		List<CompanyVO> list = null;
		if(key.equals("")) {
			list = dao.companyListJoin();
		}else {
			list = j_dao.CompanyList(startpage, endpage, s_query);
		}
		request.setAttribute("count", count);
		request.setAttribute("list", list);
		System.out.println(request.getContextPath());
		System.out.println(s_query);
		System.out.println(list);
		RequestDispatcher rd = request.getRequestDispatcher("Job_opening/job_opening_list.jsp");
		rd.forward(request, response);
		
		
		
		
	}

}
