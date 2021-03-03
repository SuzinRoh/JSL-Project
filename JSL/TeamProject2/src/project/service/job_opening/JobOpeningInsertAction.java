package project.service.job_opening;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.controller.Action;


public class JobOpeningInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Job/job_opening_insert.jsp");
		rd.forward(request, response);
		
	}

}
