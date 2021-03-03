package project.service.job_application;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.controller.Action;
import project.domain.JobApplication.Job_ApplicationDAO;
import project.domain.JobApplication.Job_ApplicationVO;
import project.domain.user.UserVO;

public class JobApplicationListUserAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		UserVO uservo = (UserVO)session.getAttribute("user");
		Job_ApplicationDAO j_dao = Job_ApplicationDAO.getInstanceof();
		System.out.println(uservo.getUser_num());
		List<Job_ApplicationVO> list = j_dao.jobApplicationSelectUser(uservo.getUser_num());
		int application_count = j_dao.countApplicationUser(uservo.getUser_num());
		
		
		request.setAttribute("list", list);
		request.setAttribute("application_count", application_count);
		System.out.println(list);
		RequestDispatcher rd = request.getRequestDispatcher("/Job/job_application_view(user).jsp");
		rd.forward(request, response);
	}

}
