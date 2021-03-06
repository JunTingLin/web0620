package com.gjun.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/showphoto")
public class ShowPhotoServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String photoName = req.getParameter("selphoto");
		String virtualPath = "img/"+photoName;
		ServletContext application = this.getServletContext();
		String realPath = application.getRealPath(virtualPath);
		File file = new File(realPath);
		InputStream is = new FileInputStream(file);
//		byte[] buffer = new byte[is.available()];
		byte[] buffer = is.readAllBytes();
		is.close();
		ServletOutputStream os = resp.getOutputStream();
		os.write(buffer);
		os.flush();
		os.close();
	}
	
}
