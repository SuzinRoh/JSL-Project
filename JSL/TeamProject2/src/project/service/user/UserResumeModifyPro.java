package project.service.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import project.controller.Action;
import project.domain.user.UserDAO;
import project.domain.user.UserResumeVO2;

public class UserResumeModifyPro implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		ServletContext context = request.getSession().getServletContext();// getServletContext();
		// 파일 저장경로
		String path = context.getRealPath("User/upload");
		String encType = "UTF-8";
		int sizeLimit = 5 * 1024 * 1024; // 파일 최대 용량설정(최대5MB)

		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		// new DefaultFileRenamePolicy() : 파일 중복시 자동이름 변경

		String str_f_l = null;
		if (multi.getParameterValues("resume_foreign_language") != null) {
			String[] resume_foreign_language = multi.getParameterValues("resume_foreign_language");
			str_f_l = resume_foreign_language[0];
			for (int i = 1; i < resume_foreign_language.length; i++) {
				str_f_l = str_f_l + "," + resume_foreign_language[i];
			}
		}
		
		String str_c = null;
		if (multi.getParameterValues("resume_certification") != null) {
			String[] resume_certification = multi.getParameterValues("resume_certification");
			str_c = resume_certification[0];
			for (int i = 1; i < resume_certification.length; i++) {
				str_c = str_c + "," + resume_certification[i];
			}
		}

		int user_num = Integer.parseInt(multi.getParameter("user_num"));

		UserResumeVO2 vo = new UserResumeVO2();
		vo.setUser_num(user_num);
		vo.setResume_gender(multi.getParameter("resume_gender"));
		vo.setResume_education(multi.getParameter("resume_education"));
		vo.setResume_tel(multi.getParameter("resume_tel"));
		vo.setResume_picture_filename(multi.getFilesystemName("resume_picture_filename"));
		vo.setResume_language(multi.getParameter("resume_language"));
		vo.setResume_foreign_language(str_f_l);
		vo.setResume_career(multi.getParameter("resume_career"));
		vo.setResume_file(multi.getFilesystemName("resume_file"));
		vo.setResume_private(multi.getParameter("resume_private"));
		vo.setResume_address(multi.getParameter("resume_address"));
		vo.setCover_num(Integer.parseInt(multi.getParameter("cover_num")));
		vo.setResume_certification(str_c);
		if (vo.getResume_picture_filename() == null) {
			vo.setResume_picture_filename(multi.getParameter("pic"));
			System.out.println(vo.getResume_picture_filename());
		}
		if (vo.getResume_file() == null) {
			vo.setResume_file(multi.getParameter("file"));
			System.out.println(vo.getResume_file());
		}
		UserDAO dao = UserDAO.getInstance();
		int row = dao.userResumeModify(vo);
		if(row == 1){
		dao.userCoverLetterChange(vo.getCover_num());
		}

		request.setAttribute("row", row);

		RequestDispatcher rd = request.getRequestDispatcher("User/user_resume_modify_pro.jsp");
		rd.forward(request, response);
	}

}
