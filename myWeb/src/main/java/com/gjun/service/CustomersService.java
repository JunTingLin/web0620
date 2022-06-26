package com.gjun.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/Customers")
public class CustomersService {
	@Path("/custqry/rawdata")
	@GET
	@Produces("text/plain")
	//傳遞國家別 進行相關客戶查詢服務 採用QueryString傳遞國家別../custqry/rawdata?country=xxx
	public String customersQry(@QueryParam("country")String country) {
		return country;
	}
}