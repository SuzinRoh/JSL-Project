package com.jslhrd.service.pds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.board.BoardVO;
import com.jslhrd.domain.guest.GuestDAO;
import com.jslhrd.domain.guest.GuestVO;
import com.jslhrd.domain.pds.PdsDAO;
import com.jslhrd.domain.pds.PdsVO;
import com.jslhrd.service.Action;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class PdsWriteProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PdsWriteProAction");
		
		request.setCharacterEncoding("utf-8");
		
		
		//파일 저장 경로 설정
		String path = request.getSession().getServletContext().getRealPath("/Pds/upload/");
		String encType = "UTF-8";
		int sizeLimit = 2*1024*1024;//최대 2메가 
		
		MultipartRequest mr = new MultipartRequest(request,path,sizeLimit,encType,new DefaultFileRenamePolicy());
		//new DefaultFileRenamePolicy() 파일 중복시 자동이름 변
		
		PdsVO vo = new PdsVO();
		vo.setContents(mr.getParameter("contents"));
		vo.setEmail(mr.getParameter("email"));
		vo.setFilename(mr.getFilesystemName("filename"));
		vo.setName(mr.getParameter("name"));
		vo.setPass(mr.getParameter("pass"));
		vo.setSubject(mr.getParameter("subject"));
		
		
		PdsDAO dao = PdsDAO.getInstance();
		int page = Integer.parseInt(mr.getParameter("page"));
		
		
		int row = dao.psdInsert(vo);
		
		request.setAttribute("page", page);
		request.setAttribute("row", row);		
		RequestDispatcher rd = request.getRequestDispatcher("Pds/pds_write_pro.jsp");
		rd.forward(request, response);

	}

}
