package exSample.servlet.Pds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import exSample.model.Pds.pdsDAO;
import exSample.model.Pds.pdsVO;

/**
 * Servlet implementation class pdsWriteServlet
 */
@WebServlet("/pdsWrite.do")
public class pdsWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pdsWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int page = Integer.parseInt(request.getParameter("page"));
		request.setAttribute("page", page);
		
		RequestDispatcher rd = request.getRequestDispatcher("Pds/pds_write.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ServletContext ct = getServletContext();
		//파일 저장 경로 설정
		String path = ct.getRealPath("/Pds/upload/");
		String encType = "UTF-8";
		int sizeLimit = 2*1024*1024;//최대 2메가 
		
		MultipartRequest mr = new MultipartRequest(request,path,sizeLimit,encType,new DefaultFileRenamePolicy());
		//new DefaultFileRenamePolicy() 파일 중복시 자동이름 변
		
		pdsVO vo = new pdsVO();
		vo.setContents(mr.getParameter("contents"));
		vo.setEmail(mr.getParameter("email"));
		vo.setFilename(mr.getFilesystemName("filename"));
		vo.setName(mr.getParameter("name"));
		vo.setPass(mr.getParameter("pass"));
		vo.setSubject(mr.getParameter("subject"));
		
		
		System.out.print("");
		pdsDAO dao = pdsDAO.getInstance();
		int page = Integer.parseInt(mr.getParameter("page"));
		
		/*
		vo.setContents(request.getParameter("contents"));
		vo.setEmail(request.getParameter("email"));
		vo.setFilename(request.getParameter("filename"));
		vo.setName(request.getParameter("name"));
		vo.setPass(request.getParameter("pass"));
		vo.setSubject(request.getParameter("subject"));
		*/
		
		int row = dao.psdInsert(vo);
		
		request.setAttribute("page", page);
		request.setAttribute("row", row);		
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Pds/pds_write_pro.jsp");
		rd.forward(request, response);
	}

}
