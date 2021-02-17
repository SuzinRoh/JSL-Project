package com.jslhrd.service.pds;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.pds.PdsDAO;
import com.jslhrd.domain.pds.PdsVO;
import com.jslhrd.service.Action;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class PdsModifyProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PdsModifyProAction");
		
		request.setCharacterEncoding("utf-8");
		
	
		ServletContext ct = request.getSession().getServletContext();

		//파일 저장 경로 설정
		String path = ct.getRealPath("/Pds/upload/");
		String encType = "UTF-8";
		int sizeLimit = 2*1024*1024;//최대 2메가 
		System.out.println(path);
		MultipartRequest mr = new MultipartRequest(request,path,sizeLimit,encType,new DefaultFileRenamePolicy());
		//new DefaultFileRenamePolicy() 파일 중복시 자동이름 변
		
		int idx = Integer.parseInt(mr.getParameter("idx"));
		int page = Integer.parseInt(mr.getParameter("page"));
		
		PdsDAO dao = PdsDAO.getInstance();
		PdsVO vo = new PdsVO();
		
		vo.setIdx(idx);
		vo.setContents(mr.getParameter("contents"));
		vo.setEmail(mr.getParameter("email"));
		vo.setFilename(mr.getFilesystemName("filename"));
		vo.setName(mr.getParameter("name"));
		vo.setPass(mr.getParameter("pass"));
		vo.setSubject(mr.getParameter("subject"));
	
		String oldfilename = mr.getParameter("oldfilename");
		
		if(vo.getFilename()==null) {
			vo.setFilename(oldfilename);
			
		} else {
			//구 파일 삭제
			System.out.print(oldfilename);
			File f = new File(path+oldfilename);
			if(f.exists()) {
				System.out.print(f);
				System.out.print("ok");
				System.out.print(f.delete());
			
			} else{
				System.out.print("nooooo");
			}
		}
	
		int row = dao.pdsModify(vo);
		
		request.setAttribute("row", row);
		request.setAttribute("page", page);
		RequestDispatcher rd = request.getRequestDispatcher("Pds/pds_modify_pro.jsp");
		rd.forward(request, response);

	}

}
