package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GuestDAO;
import model.GuestVO;

public class GuestModifyProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		GuestDAO dao = GuestDAO.getInstance();
		GuestVO vo = new GuestVO();
		
		vo.setIdx(idx);
		vo.setSubject(request.getParameter("subject"));
		vo.setContents(request.getParameter("contents"));
		vo.setPass(request.getParameter("pass"));
		
		int row = dao.GuestModify(vo);
		
		request.setAttribute("row", row);
		request.setAttribute("page", page);
		
		RequestDispatcher rd = request.getRequestDispatcher("Guest/guest_modify_pro.jsp");
		rd.forward(request, response);
		
	}

}
