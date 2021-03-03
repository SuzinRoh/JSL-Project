package project.service.company;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import project.controller.Action;
import project.domain.company.CompanyDAO;
import project.domain.company.CompanyVO;
import project.util.SHA256Util;

public class CompanyModifyInfoProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("company modify pro action");
		
		request.setCharacterEncoding("utf-8");
		
		ServletContext ct = request.getSession().getServletContext();
		//파일 저장 경로 설정
		String path = ct.getRealPath("/Company/upload/");
		String encType = "UTF-8";
		int sizeLimit = 2*1024*1024;//최대 2메가 
		
		MultipartRequest mr = new MultipartRequest(request,path,sizeLimit,encType,new DefaultFileRenamePolicy());
		
		CompanyDAO dao = CompanyDAO.getInstanceof();
		CompanyVO vo = new CompanyVO();
		
		if(mr.getParameter("pass")!=null) {
			vo.setCom_pass(SHA256Util.getEncSHA256((mr.getParameter("pass"))));
		}
		vo.setPrePass(SHA256Util.getEncSHA256((mr.getParameter("prepass"))));
		vo.setCom_id(mr.getParameter("id"));
		vo.setCom_name(mr.getParameter("name"));
		vo.setCom_empnum(Integer.parseInt(mr.getParameter("empnum")));
		/*전화번호 처리 */
		vo.setCom_tel(mr.getParameter("tel"));
		vo.setCom_info(mr.getParameter("info"));
		vo.setCom_webpage(mr.getParameter("webPage"));
		vo.setCom_working_field(mr.getParameter("workingField"));
		vo.setCom_published_date(mr.getParameter("publishedDate"));
		vo.setCom_ceo(mr.getParameter("ceo"));
		vo.setCom_capital(Integer.parseInt(mr.getParameter("capital")));
		vo.setCom_location(mr.getParameter("location"));
		vo.setCom_postnum(mr.getParameter("postnum"));
		vo.setCom_sales(Integer.parseInt(mr.getParameter("sales")));
		vo.setCom_image_filename(mr.getFilesystemName("imageFilename"));
		
		String oldfilename = mr.getParameter("oldfilename");
		
		if(vo.getCom_image_filename() == null) {
			vo.setCom_image_filename(oldfilename);
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
		
		int row = dao.companyModify(vo);

		System.out.println(row);
		PrintWriter script = response.getWriter();
		if(row == 1) {
			script.println("<script>");
			script.println("alert('ddd')");
			script.println("location.href='Main?cmd=main_index'");
			script.println("</script>");
		}else if(row == 0) {
			script.println("<script>");
			script.println("alert('no')");
			script.println("history.back()");
			script.println("</script>");
		}
		
		
       

	}

}
