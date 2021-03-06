package com.gjun.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import com.gjun.beans.MyCustomers;
import com.gjun.domain.IDao;
import com.gjun.domain.Message;
import com.gjun.domain.MyCustomersDao;

@Path("/customers")
public class CustomersService {
	@Inject
	IDao<MyCustomers> dao;

	@Path("/custqry/rawdata")
	@GET
	@Produces("application/json")
	// JAX-RS 支援Middleware將可序列化物件 回應預設序列化成Json(配合Produces())，非呈現記憶體位置
	// 傳遞國家別 進行相關客戶查詢服務 採用QueryString傳遞國家別../custqry/rawdata?country=xxx
	public Response customersQry(@Context ServletContext application, @QueryParam("country") String country) {
		DataSource datasource = (DataSource) application.getAttribute("datasource");
		// 建構DAO物件
		dao = new MyCustomersDao();
		dao.setDataSource(datasource);
		List<MyCustomers> result = null;
		Response response = null;
		
		try {
			result = dao.selectForList(country);
			response = Response.ok(result).build();
		} catch (SQLException e) {
			response = Response.status(500).entity(e.getMessage()).build();
		}
		// 判斷是否有找到資料
		if(result.size()==0) {
			Message msg = new Message();
			msg.setCode(400);
			msg.setMessage("國家別:"+country+" 沒有任何客戶記錄");
			response=Response.status(400).entity(msg).build();
		}
		return response;
	}

}
