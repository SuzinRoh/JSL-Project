package exSample.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exSample.model.Board.BoardDAO;
import exSample.model.Board.BoardVO;
import exSample.model.Guest.GuestDAO;
import exSample.model.Guest.GuestVO;

@WebServlet("/Index.do")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		GuestDAO guestDao = GuestDAO.getInstance();
		BoardDAO boardDao = BoardDAO.getInstance();
		
		List<GuestVO> guestList = guestDao.GuestSelectMain();
		List<BoardVO> boardList = boardDao.BoardSelectMain();
		
		request.setAttribute("guestList", guestList);
		request.setAttribute("boardList", boardList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Main/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
