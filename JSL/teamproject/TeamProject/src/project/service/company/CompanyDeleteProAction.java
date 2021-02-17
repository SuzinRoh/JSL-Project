package project.service.company;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import project.controller.Action;
import project.domain.company.CompanyDAO;
import project.domain.company.CompanyVO;
import project.util.SHA256Util;

public class CompanyDeleteProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("company delete pro action");
		
		request.setCharacterEncoding("utf-8");
		
		CompanyDAO dao = CompanyDAO.getInstanceof();
		String id = request.getParameter("id");
		String pass = SHA256Util.getEncSHA256((request.getParameter("pass")));
		System.out.println(id);
		System.out.println(pass);
		
		int row = dao.companyDelete(id, pass);
		
		PrintWriter script = response.getWriter();
		if(row == 1) {
			HttpSession session = request.getSession();
			session.invalidate();
			script.println("<script>");
			script.println("alert('성공')");
			script.println("location.href='Main?cmd=main_index'");
			script.println("</script>");
		}else if(row == 0) {
			script.println("<script>");
			script.println("alert('false')");
			script.println("history.back()");
			script.println("</script>");
		}
		
		
       

	}

}
