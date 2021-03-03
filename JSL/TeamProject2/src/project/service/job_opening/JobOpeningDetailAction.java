package project.service.job_opening;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.controller.Action;
import project.domain.JobApplication.Job_ApplicationDAO;
import project.domain.company.CompanyVO;
import project.domain.job_opening.Job_openingDAO;
import project.domain.user.UserVO;

public class JobOpeningDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String id = request.getParameter("id");
//		
//		CompanyDAO dao = CompanyDAO.getInstanceof();
//		dao.companyInfo(id);
		System.out.println("CompanyInfoDetailAction");
		System.out.println("CompanyInfoDetailAction");
		
		int num  = Integer.parseInt(request.getParameter("num"));
		System.out.println("opening_num은 :" + num);
		
		//CompanyDAO dao = CompanyDAO.getInstanceof();
		Job_openingDAO dao = Job_openingDAO.getInstanceof();
		
		
		CompanyVO vo = dao.companyDetail(num);
		int openingnum = vo.getOpening_num();
		List<CompanyVO> list = dao.openingListRecommend();
		
		
//		System.out.println(vo2.getCom_num());
//		
		Job_ApplicationDAO ja_dao = Job_ApplicationDAO.getInstanceof();
		HttpSession session = request.getSession();
		UserVO uservo = null;
		if(session.getAttribute("user") != null) {
			uservo = (UserVO)session.getAttribute("user");
			int submited = ja_dao.countApplicationUser(uservo.getUser_num(), num); // 0이면 미신청자 1이상이면 신청자로 구분 
			
			request.setAttribute("submited", submited);
		}
		
		
		request.setAttribute("list", list);
		request.setAttribute("vo",vo);
		request.setAttribute("openingnum", openingnum);
		RequestDispatcher rd =request.getRequestDispatcher("Job/job_opening_detail.jsp");
		rd.forward(request, response);
	}

}
