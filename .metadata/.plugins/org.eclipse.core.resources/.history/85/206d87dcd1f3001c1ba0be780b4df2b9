package com.gjun.controllor;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.gjun.beans.Users;
import com.gjun.domain.IDao;
import com.gjun.domain.UsersDao;
import com.mysql.cj.jdbc.MysqlDataSource;

/**
 * Servlet implementation class LoginValidServlet
 */
@WebServlet("/LoginValidServlet")
public class LoginValidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginValidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message;
		String username = request.getParameter("username");
		String passWord = request.getParameter("password");
		DataSource datasource = (MysqlDataSource)this.getServletContext().getAttribute("datasource");
		IDao<Users> users = new UsersDao();
		users.setDataSource(datasource);
		try {
			boolean r = users.selectForObject(username, passWord);
			if(r) {
				System.out.println("驗證通過");
				Cookie cookie = new Cookie("cred", username);
				cookie.setPath("/acct");
				response.addCookie(cookie);
				
				HttpSession session = request.getSession();
				session.setAttribute("cred", username);
				
				message=String.format("%s 驗證通過", username);
			}else {
				System.out.println("驗證失敗，帳密不正確");
				message=String.format("%s 驗證失敗，帳密不正確", username);
			}
			request.setAttribute("message", message);
			RequestDispatcher disp = request.getRequestDispatcher("showlogin.jsp");
			disp.forward(request, response);
		} catch (SQLException e) {
			System.out.println("錯誤訊息: "+e.getMessage());
		}
	}

}
