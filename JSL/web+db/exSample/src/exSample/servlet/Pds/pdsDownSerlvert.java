package exSample.servlet.Pds;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pds_down.do")
public class pdsDownSerlvert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public pdsDownSerlvert() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String filename = request.getParameter("filename");

		String path = request.getRealPath("/")+ "Pds/upload/";
		
		File file = new File(path+filename);
		
		String Agent = request.getHeader("USER-AGENT");
		response.setContentType("application/octet-stream;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment; Filename="+URLEncoder.encode(filename));
		
		try {
			System.out.println("ok1");
			byte b[] = new byte[5*1024*1024];
			if(file.isFile()) {
				System.out.println("ok2");
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
				System.out.println("?"+bis);
				BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
				
				System.out.println("?"+bos);
				try {
					//System.out.println("ok3");
					int read = 0;
					while((read = bis.read(b)) != -1) {
						//System.out.println("ok4");
						bos.write(b,0,read);
					}
					bos.flush();
				
					bos.close();
					bis.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
