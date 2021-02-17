package exAdmin.servlet.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exAdmin.model.adminNoticeDAO;
import exAdmin.model.adminNoticeVO;

/**
 * Servlet implementation class adminNoticeModifyServlet
 */
@WebServlet("/adminNoticeModify.do")
public class adminNoticeModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminNoticeModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		adminNoticeVO vo = new adminNoticeVO();
		adminNoticeDAO dao = adminNoticeDAO.getInstance();
		
		vo = dao.noticeSelect(idx);
		vo.setContents(vo.getContents().replace("\n", "<br>"));
		
		request.setAttribute("idx", idx);
		request.setAttribute("page", page);
		request.setAttribute("vo", vo);
		RequestDispatcher rd = request.getRequestDispatcher("/Admin/notice_modify.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		String sub =request.getParameter("subject");
		String con =request.getParameter("contents");
		String pass =request.getParameter("pass");
		adminNoticeVO vo = new adminNoticeVO();
		adminNoticeDAO dao = adminNoticeDAO.getInstance();
		
		
		int row = dao.NoticeModify(sub,con,idx,pass);
		
		
		request.setAttribute("page", page);
		request.setAttribute("row", row);
		RequestDispatcher rd = request.getRequestDispatcher("Admin/notice_modify_pro.jsp");
		rd.forward(request, response);
	}

}
