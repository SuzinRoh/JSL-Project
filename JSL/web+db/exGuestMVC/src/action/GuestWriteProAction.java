package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GuestDAO;
import model.GuestVO;

public class GuestWriteProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			int page = Integer.parseInt(request.getParameter("page"));
		   
		
			GuestDAO dao = GuestDAO.getInstance();
			GuestVO vo = new GuestVO();
			
			
			vo.setName(request.getParameter("name"));
			System.out.println(request.getParameter("name"));
			vo.setSubject(request.getParameter("subject"));
			vo.setContents(request.getParameter("contents"));
			vo.setPass(request.getParameter("pass"));
			
			int row = dao.GuestInsert(vo);
		
		   request.setAttribute("page", page);
		   request.setAttribute("row", row);
		   RequestDispatcher dispatcher = request.getRequestDispatcher("Guest/guest_write_pro.jsp");
		   dispatcher.forward(request, response);
	}

}
