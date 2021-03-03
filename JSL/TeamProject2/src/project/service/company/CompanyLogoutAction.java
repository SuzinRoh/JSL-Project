package project.service.company;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.controller.Action;

public class CompanyLogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("CompanyLogout");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		session.invalidate();
		
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그아웃 되었습니다.')");
		script.println("location.href='Main?cmd=main_index'");
		script.println("</script>");
		
		
	}

}
