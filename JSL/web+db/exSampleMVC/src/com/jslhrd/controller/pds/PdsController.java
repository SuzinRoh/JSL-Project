package com.jslhrd.controller.pds;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.service.Action;

@WebServlet("/Pds")
public class PdsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public PdsController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		System.out.println("cmd :" +cmd);
		PdsActionFactory paf = PdsActionFactory.getInstace();
		Action action = paf.getAction(cmd);
		if(action != null) {
			action.execute(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
