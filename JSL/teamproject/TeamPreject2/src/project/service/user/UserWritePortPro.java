package project.service.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import project.controller.Action;
import project.domain.user.UserDAO;
import project.domain.user.UserPortVO;
import project.domain.user.UserVO;

public class UserWritePortPro implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		ServletContext context = request.getSession().getServletContext();
		UserDAO DAO = UserDAO.getInstance();

		//���� ���� ���
		String path = context.getRealPath("User/upload");
		String encType = "utf-8";
		int sizeLimit = 1000*1024*1024; //���� �ִ� �뷮 ����
		
		MultipartRequest multi = new MultipartRequest(request,path,sizeLimit,encType, new DefaultFileRenamePolicy());
		//���� �ߺ��� �ڵ� �̸� ����
		
		HttpSession session = request.getSession();
		UserVO vo = (UserVO)session.getAttribute("user");
		UserPortVO vo2 = new UserPortVO();
		int usernum = vo.getUser_num();
		vo2.setPort_filename(multi.getFilesystemName("filename"));
		vo2.setUser_num(usernum);
		vo2.setPort_link(multi.getParameter("portlink"));
		
		int row = DAO.userWritePort(vo2);
		request.setAttribute("row", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("/User/user_write_port_pro.jsp");
		rd.forward(request, response);
		
		
		
	}

}
