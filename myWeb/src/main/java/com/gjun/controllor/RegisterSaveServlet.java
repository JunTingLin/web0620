package com.gjun.controllor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.gjun.beans.Users;
import com.gjun.domain.IDao;
import com.gjun.domain.UsersDao;

/**
 * Servlet implementation class RegisterSaveServlet
 */
@WebServlet("/RegisterSaveServlet")
public class RegisterSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterSaveServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 擷取表單欄位內容
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String realName = request.getParameter("realname");
		String email = request.getParameter("email");
//		response.getWriter().print(userName);
		Users users = new Users();
		users.setUserName(userName);
		users.setPassword(password);
		users.setRealName(realName);
		users.setEmail(email);
		//可參考應用系統聆聽器ApplicationHandler裡application.setAttribute，活得比較久共用
		//這裡request死掉，我的users javaBean就釋放
		request.setAttribute("users", users);
		
		DataSource datasource = 
				(DataSource) this.getServletContext().getAttribute("datasource");
		IDao<Users> dao = new UsersDao();
		dao.setDataSource(datasource);
		try {
			dao.insert(users);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/views/showresult.jsp");
		disp.forward(request, response);
		
	}

}
