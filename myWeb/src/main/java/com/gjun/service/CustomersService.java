package com.gjun.service;


import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

@Path("/Customers")
public class CustomersService {
	@Path("/custqry/rawdata")
	@GET
	@Produces("text/plain")
	//傳遞國家別 進行相關客戶查詢服務 採用QueryString傳遞國家別../custqry/rawdata?country=xxx
	public String customersQry(@Context ServletContext application,@QueryParam("country")String country) {
		DataSource datasource = (DataSource) application.getAttribute("datasource");
		String dbName = null;
		try {
			Connection connection = datasource.getConnection();
			dbName=connection.getCatalog();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dbName;
	}
	
}
