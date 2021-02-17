package com.jslhrd.controller.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.service.Action;


@WebServlet("/Notice")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public NoticeController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		
		NoticeActionFactory naf = NoticeActionFactory.getInstance();
		Action action = naf.getAction(cmd);
		if(action != null) {
			action.execute(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
