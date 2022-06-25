package com.gjun.controllor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CountryListServlet
 */
@WebServlet("/CountryListServlet")
public class CountryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountryListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> countries = new ArrayList<>();
		countries.add("美國");
		countries.add("英國");
		countries.add("德國");
		countries.add("義大利");
		countries.add("西班牙");
		request.setAttribute("countries", countries);
		RequestDispatcher disp = request.getRequestDispatcher("countryselect.jsp");
		disp.forward(request, response);
		
	}

	
}
