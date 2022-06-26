package com.gjun.view;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;



import com.gjun.entity.AppConfig;

public class ApplicationConfigServlet extends HttpServlet{

	

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Application config Servlet活過來了...");
		ServletContext application = this.getServletContext();
		
		String realPath = application.getRealPath("/WEB-INF/app.properties");
		try {
			InputStream is = new FileInputStream(realPath);
			Properties pro = new Properties();
			pro.load(is);
			
			AppConfig config = new AppConfig();
			config.setUrl(pro.getProperty("db.url"));
			config.setUserName(pro.getProperty("db.username"));
			config.setPassword(pro.getProperty("db.password"));
			config.setAddress(pro.getProperty("address"));
			config.setCompanyName(pro.getProperty("companyname"));
			application.setAttribute("appConfig", config);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("應用系統聆聽器 活過來了...(非真實datasource)");
		System.out.println("獲取資源檔參數: "+
				((AppConfig)application.getAttribute("appConfig")).getAddress());
		
	}
	
}
