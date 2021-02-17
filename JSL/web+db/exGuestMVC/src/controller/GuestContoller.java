package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.GuestDeleteAction;
import action.GuestDeleteProAction;
import action.GuestListAction;
import action.GuestModifyAction;
import action.GuestModifyProAction;
import action.GuestViewAction;
import action.GuestWriteAction;
import action.GuestWriteProAction;

@WebServlet("/Guest")
public class GuestContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GuestContoller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 클라이언트 요청 받기
		String cmd = request.getParameter("cmd");
		System.out.print("요청받음을확인 :" + cmd);
		Action action = null;
		if (cmd.equals("guest_list")) {
			// 리스트 수행
			action = new GuestListAction();

		} else if (cmd.equals("guest_write")) {
			// 등록
			action = new GuestWriteAction();

		} else if (cmd.equals("guest_write_pro")) {
			// 등록처리
			action = new GuestWriteProAction();
			
		} else if (cmd.equals("guest_view")) {
			action = new GuestViewAction();
			
		} else if (cmd.equals("guest_modify")) {
			action = new GuestModifyAction();
			
		} else if (cmd.equals("guest_modify_pro")) {
			action = new GuestModifyProAction();
			
		} else if (cmd.equals("guest_delete")) {
			action = new GuestDeleteAction();
			
		} else if (cmd.equals("guest_delete_pro")) {
			action = new GuestDeleteProAction();
			
		}
		action.execute(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
