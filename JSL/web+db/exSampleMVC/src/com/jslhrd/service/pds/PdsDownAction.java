package com.jslhrd.service.pds;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.service.Action;

public class PdsDownAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String filename = request.getParameter("filename");
		String path = request.getRealPath("/") + "Pds/upload/";
		File file = new File(path + filename);

		String Agent = request.getHeader("USER-AGENT");
		response.setContentType("application/octet-stream;charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment; Filename=" + URLEncoder.encode(filename));

		try {
			byte b[] = new byte[5 * 1024 * 1024];
			if (file.isFile()) {
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
				BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
				try {
					int read = 0;
					while ((read = bis.read(b)) != -1) {
						bos.write(b, 0, read);
					}
					bos.flush();
					bos.close();
					bis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
