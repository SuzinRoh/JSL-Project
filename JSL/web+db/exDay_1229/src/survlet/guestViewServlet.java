package survlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exDay_1229.model.GuestDTO;
import exDay_1229.model.guestDAO;

/**
 * Servlet implementation class guestViewServlet
 */
@WebServlet("/guest_view")
public class guestViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public guestViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tmp1 =request.getParameter("idx");
		String tmp2 =request.getParameter("page");
		int idx = Integer.parseInt(tmp1);
		int page = Integer.parseInt(tmp2);
		
		guestDAO dao =guestDAO.getInstance();
		//쿠키검사 및 생성
		boolean b = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		for(int x=0; x < cookies.length; x++) {
			info = cookies[x];
			if(info.getName().equals("GuestCookie"+idx)) {
				b=true;
				break;
			}
		}
		String newValue =""+System.currentTimeMillis();
		if(!b) {
			dao.guestHits(idx);//조회수 증가
			info = new Cookie("GuestCookie"+idx, newValue);
			info.setMaxAge(60*60);
			response.addCookie(info);
		}
		
		GuestDTO guest = dao.guestSelect(idx);
		guest.setContents(guest.getContents().replace("\n", "<br>"));
		
		request.setAttribute("guest", guest);
		request.setAttribute("page", page);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Guest/guest_view.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
