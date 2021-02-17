package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Action;
import service.board.BoardListAction;

@WebServlet("/Board")
public class BoardContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public BoardContoller() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String cmd = request.getParameter("cmd");
		//System.out.println("Board contoller 요청 :" + cmd);
		
		BoardActionFactory af = BoardActionFactory.getInstace();
		Action action = af.getAction(cmd);
		
		if(action != null) {
			action.execute(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
