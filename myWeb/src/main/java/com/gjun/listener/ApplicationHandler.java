package com.gjun.listener;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.gjun.domain.AppDBUtility;
import com.gjun.entity.AppConfig;

public class ApplicationHandler implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		ServletContext application = sce.getServletContext();
		AppDBUtility.createDataSource(application, "dbconfig.properties");
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
			
			System.out.println("應用系統聆聽器 活過來了");
			System.out.println(((AppConfig)application.getAttribute("appConfig")).getAddress());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
