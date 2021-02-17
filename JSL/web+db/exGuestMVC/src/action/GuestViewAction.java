package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GuestDAO;
import model.GuestVO;

public class GuestViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		GuestDAO dao = GuestDAO.getInstance();
		
		boolean b = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		for(int x = 0; x <cookies.length; x++) {
			info = cookies[x];
			if(info.getName().equals("GuestCookie"+idx)) {
				b = true;
				break;
			}
		}
		String newValue =""+System.currentTimeMillis();
		if(!b) {
			dao.GuestHits(idx);
			info = new Cookie("GuestCookie"+idx, newValue);
			info.setMaxAge(60*60*60);
			response.addCookie(info);
		}
		
		
		
		GuestVO vo = dao.GuestView(idx);
		
		vo.setContents(vo.getContents().replace("\n", "<br>"));
		request.setAttribute("guest", vo);
		request.setAttribute("page", page);

		RequestDispatcher dispatcher =request.getRequestDispatcher("Guest/guest_view.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
