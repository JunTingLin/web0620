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
		
		DataSource datasource = (DataSource) this.getServletContext().getAttribute("datasource");
		try {
			Connection connection = datasource.getConnection();
			String sql = "INSERT INTO javausers(username,password,realname,email) VALUES(?,?,?,?)";
			PreparedStatement st =connection.prepareStatement(sql);
			st.setString(1, users.getUserName());
			st.setString(2, users.getPassword());
			st.setString(3, users.getRealName());
			st.setString(4, users.getEmail());
			int r = st.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/views/showresult.jsp");
		disp.forward(request, response);
		
	}

}
