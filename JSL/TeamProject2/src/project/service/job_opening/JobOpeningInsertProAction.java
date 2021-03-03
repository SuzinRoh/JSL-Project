package project.service.job_opening;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import project.controller.Action;
import project.domain.job_opening.Job_openingDAO;
import project.domain.job_opening.Job_openingVO;


public class JobOpeningInsertProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String language = "";
		if(request.getHeader("accept-language")!=null) {
			language = request.getHeader("accept-language");
		}
		language = language.substring(0,2);
		request.setAttribute("language", language);
		
		String path = request.getSession().getServletContext().getRealPath("/Job/upload/");
		String encType = "UTF-8";
		int sizeLimit = 60*1024*1024;//최대 60메가 
		MultipartRequest mr = new MultipartRequest(request,path,sizeLimit,encType,new DefaultFileRenamePolicy());
		
		String filename = null;
		Enumeration en = mr.getFileNames();
		String strName = (String)en.nextElement();
		filename = mr.getFilesystemName(strName);

		System.out.println(filename);
		
		Job_openingVO vo = new Job_openingVO();
		Job_openingDAO dao = Job_openingDAO.getInstanceof();
		vo.setCom_num(Integer.parseInt(mr.getParameter("com_num")));
		vo.setOpening_subject(mr.getParameter("subject"));
		vo.setOpening_duty(mr.getParameter("duty"));
		vo.setOpening_offer(mr.getParameter("offer"));
		vo.setOpening_carrer(mr.getParameter("carrer"));
		vo.setOpening_scale(mr.getParameter("scale"));
		vo.setOpening_location(mr.getParameter("location"));
		vo.setOpening_salary(Integer.parseInt(mr.getParameter("salary")));
		vo.setOpening_startdate(mr.getParameter("startdate"));
		vo.setOpening_enddate(mr.getParameter("enddate"));
		vo.setOpening_contents(mr.getParameter("contents"));
		vo.setOpening_working_time(mr.getParameter("working_time"));
		vo.setOpening_filename(filename);
		vo.setOpening_education(mr.getParameter("education"));
		int row = dao.JobOpeningInsert(vo);
		request.setAttribute("row", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("Job/job_opening_insert_pro.jsp");
		rd.forward(request, response);
		
	}

}
