package com.gjun.domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class AppDBUtility {
	public static void createDataSource(ServletContext application, String config) {
		MysqlDataSource datasource = new MysqlDataSource();
		String realPath = application.getRealPath("/WEB-INF")+"/"+config;
		Properties properites = new Properties();
		try {
			properites.load(new FileInputStream(realPath));
			datasource.setUrl(properites.getProperty("db.url"));
			datasource.setUser(properites.getProperty("db.username"));
			datasource.setPassword(properites.getProperty("db.password"));
			
			application.setAttribute("datasource", datasource);
			System.out.println("DataSource建立了..."+datasource);
			
			
		} catch (FileNotFoundException e) {
			System.out.println("DataSource建立錯誤: "+e.getMessage());
		} catch (IOException e) {
			System.out.println("DataSource建立錯誤: "+e.getMessage());
		} 

	}
}
