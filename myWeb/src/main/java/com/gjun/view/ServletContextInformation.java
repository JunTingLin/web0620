package com.gjun.view;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContextInformation
 */
@WebServlet("/ServletContextInformation")
public class ServletContextInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletContextInformation() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext();
		String contextPath = application.getContextPath();
		System.out.println("contextPath: "+contextPath+"\n");
		System.out.println(request.getLocalName());
		
	}

}
