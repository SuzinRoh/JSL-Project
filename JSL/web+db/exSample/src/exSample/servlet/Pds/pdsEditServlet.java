package exSample.servlet.Pds;

import java.io.File;
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
 * Servlet implementation class pdsEditServlet
 */
@WebServlet("/pdsEdit.do")
public class pdsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pdsEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int idx =Integer.parseInt(request.getParameter("idx"));
		int page =Integer.parseInt(request.getParameter("page"));
		
		pdsDAO dao = pdsDAO.getInstance();
		pdsVO vo = dao.pdsVeiw(idx);
		
		request.setAttribute("idx", idx);
		request.setAttribute("page", page);
		request.setAttribute("vo", vo);
		RequestDispatcher rd = request.getRequestDispatcher("Pds/pds_modify.jsp");
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
		int page = Integer.parseInt(mr.getParameter("page"));
		
		vo.setIdx(Integer.parseInt(mr.getParameter("idx")));
		vo.setContents(mr.getParameter("contents"));
		vo.setEmail(mr.getParameter("email"));
		vo.setFilename(mr.getFilesystemName("filename"));
		vo.setName(mr.getParameter("name"));
		vo.setPass(mr.getParameter("pass"));
		vo.setSubject(mr.getParameter("subject"));
		
		String oldfilename = mr.getParameter("oldfilename");
		System.out.print(oldfilename);
		//첨부파일이있는지 검사
		
		if(vo.getFilename()==null) {
			vo.setFilename(oldfilename);
			
		} else {
			//구 파일 삭제
			System.out.print(oldfilename);
			File f = new File(path+oldfilename);
			if(f.exists()) {
				//System.out.print(f);
				//System.out.print("ok");
				//System.out.print(f.delete());
				f.delete();
			} else{
				System.out.print("nooooo");
			}
		}
			
		
		System.out.print("");
		pdsDAO dao = pdsDAO.getInstance();
		
		int row = dao.pdsModify(vo);
		
		request.setAttribute("row", row);
		request.setAttribute("page", page);
		
		RequestDispatcher rd = request.getRequestDispatcher("Pds/pds_modify_pro.jsp");
		rd.forward(request, response);
	}

}
