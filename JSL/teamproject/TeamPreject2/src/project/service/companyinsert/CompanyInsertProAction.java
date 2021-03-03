package project.service.companyinsert;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import project.controller.Action;
import project.domain.company.CompanyDAO;
import project.domain.company.CompanyVO;
import project.util.SHA256Util;

public class CompanyInsertProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("company insert pro action");
		
		request.setCharacterEncoding("utf-8");
		
		//파일 저장 경로 설정
		String path = request.getSession().getServletContext().getRealPath("/Company/upload/");
		String encType = "UTF-8";
		int sizeLimit = 2*1024*1024;//최대 2메가 
		MultipartRequest mr = new MultipartRequest(request,path,sizeLimit,encType,new DefaultFileRenamePolicy());
		
		CompanyDAO dao = CompanyDAO.getInstanceof();
		CompanyVO vo = new CompanyVO();
		
		vo.setCom_id(mr.getParameter("id"));
		vo.setCom_pass(SHA256Util.getEncSHA256((mr.getParameter("pass"))));
		vo.setCom_email(mr.getParameter("mail"));
		
		
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
		
		
		int row = dao.insertCompany(vo);
		
		request.setAttribute("row", row);
		if(row==1) {
			RequestDispatcher rd = request.getRequestDispatcher("/Main?cmp=main_index");
		} else {
			
		}
		

	}

}
