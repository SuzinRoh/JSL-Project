package exSample.servlet.Guest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exSample.model.Guest.GuestDAO;
import exSample.model.Guest.GuestVO;

@WebServlet("/GuestView.do")
public class GuestViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public GuestViewServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		GuestDAO dao = GuestDAO.getInstance();
		
		boolean b =false;
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
		
		request.setAttribute("idx", idx);
		request.setAttribute("vo", vo);
		request.setAttribute("page", page);
		
		RequestDispatcher rd = request.getRequestDispatcher("Guest/guest_view.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
