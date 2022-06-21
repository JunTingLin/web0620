package com.gjun.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CityServlet extends HttpServlet{
//	private ServletConfig config;
	private String[] items;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<select>");
		//走訪陣列
		for(String city:items) {
			out.println("<option value='"+city+"'>"+city+"</option>");
		}
		out.println("</select>");
	}


	@Override
	public void init(ServletConfig config) throws ServletException {
//		super.init(config);
		System.out.println("City servlet活過來了...");
		String names = config.getInitParameter("cities");
		items=names.split(",");
		
	}
	
}
