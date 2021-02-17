package com.jslhrd.controller.guest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.service.Action;

@WebServlet("/Guest")
public class GuestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public GuestController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		
		GuestActionFactory baf = GuestActionFactory.getInstace();
		Action action = baf.getAction(cmd);
		if(action != null) {
			action.execute(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
