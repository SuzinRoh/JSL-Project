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

import exSample.model.Pds.pdsDAO;

/**
 * Servlet implementation class psdDelServlet
 */
@WebServlet("/pdsDel.do")
public class pdsDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pdsDelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		request.setAttribute("idx", idx);
		request.setAttribute("page", page);
		
		RequestDispatcher rd= request.getRequestDispatcher("Pds/pds_delete.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int page = Integer.parseInt(request.getParameter("page"));
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		String pass = request.getParameter("pass");
		pdsDAO dao=pdsDAO.getInstance();
		String filename = dao.getFile(idx);
		int row = dao.pdsDelete(idx,pass);
		if(row==1) {
			ServletContext sc = getServletContext();
			String path = sc.getRealPath("Pds/upload/");
			File file =new File(path+filename);
			if(file.exists()) {
				file.delete();
			}
		}
		request.setAttribute("row", row);
		request.setAttribute("page", page);
		
		RequestDispatcher rd= request.getRequestDispatcher("Pds/pds_delete_pro.jsp");
		rd.forward(request, response);
		
		
		
	}

}
