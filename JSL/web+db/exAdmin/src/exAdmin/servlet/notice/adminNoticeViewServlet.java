package exAdmin.servlet.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exAdmin.model.adminNoticeDAO;
import exAdmin.model.adminNoticeVO;

/**
 * Servlet implementation class adminNoticeViesServlet
 */
@WebServlet("/adminNoticeView.do")
public class adminNoticeViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminNoticeViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));

		adminNoticeVO vo = new adminNoticeVO();
		adminNoticeDAO dao = adminNoticeDAO.getInstance();

		boolean b = false;

		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			info = cookies[i];
			if (info.getName().equals("NoticeCookie" + idx)) {
				b = true;
				break;
			}
		}
		String newValue = "" + System.currentTimeMillis();
		if (!b) {
			dao.NoticeHits(idx);
			info = new Cookie("NoticeCookie" + idx, newValue);
			info.setMaxAge(60 * 60);
			response.addCookie(info);
		}

		vo = dao.noticeSelect(idx);
		
		vo.setContents(vo.getContents().replace("\n", "<br>"));
		
		request.setAttribute("idx", idx);
		request.setAttribute("page", page);
		request.setAttribute("vo", vo);
		

		RequestDispatcher rd = request.getRequestDispatcher("Admin/notice_view.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
