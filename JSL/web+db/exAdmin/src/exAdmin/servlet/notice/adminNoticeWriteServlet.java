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
 * Servlet implementation class adminNoticeWriteServlet
 */
@WebServlet("/adminNoticeWrite.do")
public class adminNoticeWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminNoticeWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page= Integer.parseInt(request.getParameter("page"));
		
		request.setAttribute("page", page);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Admin/notice_write.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int page= Integer.parseInt(request.getParameter("page"));
		
		adminNoticeDAO dao = adminNoticeDAO.getInstance();
		adminNoticeVO vo = new adminNoticeVO();
		
		
		vo.setSubject(request.getParameter("subject"));
		vo.setPass(request.getParameter("pass"));
		vo.setContents(request.getParameter("contents"));
		
		System.out.println(request.getParameter("subject"));
		System.out.println(request.getParameter("pass"));
		System.out.println(request.getParameter("contents"));
		
		int row = dao.noticeWrite(vo);
		
		
		request.setAttribute("page", page);	
		request.setAttribute("row", row);	
		RequestDispatcher rd = request.getRequestDispatcher("/Admin/notice_write_pro.jsp");
		rd.forward(request, response);
	}

}
