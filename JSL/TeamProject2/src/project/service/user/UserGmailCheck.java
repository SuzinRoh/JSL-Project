package project.service.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.controller.Action;
import project.domain.user.UserDAO;
import project.domain.user.UserVO;
import project.util.SHA256Mail;

public class UserGmailCheck implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("check");
		UserDAO DAO = UserDAO.getInstance();
		HttpSession session = request.getSession();
		UserVO VO = (UserVO) session.getAttribute("user");
		String userid = VO.getUser_id();
		String email = VO.getUser_email();
		String code = request.getParameter("code");
		boolean rightCode = 
				SHA256Mail.getEncrypt(email, "cos").equals(code) ? true : false;
		PrintWriter script = response.getWriter();
		if(rightCode == true){
			DAO.userEmailAuth(userid);
			System.out.println("로그인하였습니다");
			script.println("<script>");
			script.println("alert('Success')");
			//script.println("location.href='login.jsp'");
			script.println("</script>");
		} else{
			System.out.println("로그인 실패");
			script.println("<script>");
			script.println("alert('Fail')");
			//script.println("location.href='error.jsp'");
			script.println("</script>");
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Rapid/index.jsp");
		dispatcher.forward(request, response);
		
	}

}
