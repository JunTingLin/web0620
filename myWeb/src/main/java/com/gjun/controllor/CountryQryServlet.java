package com.gjun.controllor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gjun.beans.MyCustomers;
import com.gjun.domain.IDao;
import com.gjun.domain.MyCustomersDao;
import com.mysql.cj.jdbc.MysqlDataSource;

/**
 * Servlet implementation class CountryQryServlet
 */
@WebServlet("/CountryQryServlet")
public class CountryQryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountryQryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String country = request.getParameter("country");
		MysqlDataSource datasource =(MysqlDataSource) this.getServletContext().getAttribute("datasource");
		IDao<MyCustomers> dao = new MyCustomersDao();
		dao.setDataSource(datasource);
		try {
			List<MyCustomers> MyCustomersList  =dao.selectForList(country);
			request.setAttribute("myCustomersList", MyCustomersList);
			request.getRequestDispatcher("showcountrydata.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
