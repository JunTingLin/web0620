package com.gjun.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterSave")
public class RegisterServlet extends HttpServlet {
	int i = 0;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("In Register Servlet"+(i++));
		// 0.設定擷取編碼
		req.setCharacterEncoding("UTF-8");
		// 回應編碼規則
		resp.setContentType("text/html;charset=UTF-8");
		// 1 擷取前端表單頁面欄位name=xxxx
		String userName = req.getParameter("username");
		String password = req.getParameter("pwd"); 
		String realName = req.getParameter("realname");
		String email = req.getParameter("email");
		// 進行註冊處理....
		// 成功與否 回訊息給前端(View)
		PrintWriter out = resp.getWriter();
		out.println("使用者帳號:" + userName);
	}

}
