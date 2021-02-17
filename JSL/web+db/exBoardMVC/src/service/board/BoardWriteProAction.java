package service.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;
import service.Action;

public class BoardWriteProAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IN board_write_pro.jsp");
		
		int page = Integer.parseInt(request.getParameter("page"));
		
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = new BoardVO();
		
		
		vo.setName(request.getParameter("name"));
		vo.setEmail(request.getParameter("email"));
		vo.setSubject(request.getParameter("subject"));
		vo.setContents(request.getParameter("contents"));
		vo.setPass(request.getParameter("pass"));
		
		int row = dao.BoardWrite(vo);
		
		request.setAttribute("page",page);
		request.setAttribute("row",row);
		RequestDispatcher rd = request.getRequestDispatcher("Board/board_write_pro.jsp");
		rd.forward(request, response);
	}
}
