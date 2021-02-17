package com.jslhrd.controller.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.service.Action;
import com.jslhrd.service.main.MainAction;

@WebServlet("/Main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MainController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String cmd = request.getParameter("cmd");
		System.out.println("Main contoller 요청 :" + cmd);
		Action action = null;
		
		
		if(cmd.equals("index")) {
			action = new MainAction();
		}
		action.execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
