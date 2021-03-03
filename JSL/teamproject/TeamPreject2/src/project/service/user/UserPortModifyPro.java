package project.service.user;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import project.controller.Action;
import project.domain.user.UserDAO;
import project.domain.user.UserPortVO;

public class UserPortModifyPro implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		ServletContext context = request.getSession().getServletContext();
		//���� ���� ���
		String path = context.getRealPath("User/upload/");
		String encType = "utf-8";
		int sizeLimit = 1000*1024*1024; //���� �ִ� �뷮 ����
		
		MultipartRequest multi = new MultipartRequest(request,path,sizeLimit,encType, new DefaultFileRenamePolicy());
		//���� �ߺ��� �ڵ� �̸� ����
		UserPortVO vo = new UserPortVO();
		String[] privit = multi.getParameterValues("private");
		int port_num = Integer.parseInt(multi.getParameter("port_num"));
		String tmppri = "";
		for(int i = 0 ; i < privit.length; i++) {
			if(privit[i] != null) {
				tmppri = privit[i];
			}
		}
		String nowfilename = multi.getParameter("nowfilename");
		vo.setPort_num(port_num);
		vo.setPort_link(multi.getParameter("portlink"));
		vo.setPort_filename(multi.getFilesystemName("newfilename"));
		vo.setPort_private(tmppri);
		
		
		File file = new File(path+nowfilename);
			if(file.exists()) {
				file.delete();
			}
		
		UserDAO DAO = UserDAO.getInstance();
		int row = DAO.userPortModify(vo);
		
		request.setAttribute("row", row);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/User/user_port_modify_pro.jsp");
		dispatcher.forward(request, response);
	}

}
