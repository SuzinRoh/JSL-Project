package project.service.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.controller.Action;
import project.domain.user.UserDAO;
import project.domain.user.UserPortVO;
import project.domain.user.UserVO;

public class UserPortList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDAO DAO = UserDAO.getInstance();
		List<UserPortVO> list = new ArrayList<UserPortVO>();
		HttpSession session = request.getSession();
		UserVO vo = (UserVO)session.getAttribute("user");
		//comvo 기업세션이름
		
		int usernum = vo.getUser_num();
		list = DAO.userPortList(usernum);
		int totcount = DAO.userPortCount(usernum);
		
		request.setAttribute("totcount", totcount);
		request.setAttribute("portfolio", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/User/user_port_list.jsp");
		rd.forward(request, response);
		
	}

}
