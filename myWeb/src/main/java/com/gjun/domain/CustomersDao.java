package com.gjun.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.gjun.beans.Customers;



public class CustomersDao implements IDao<Customers>{
	private DataSource datasource;

	@Override
	public void setDataSource(DataSource datasource) {
		this.datasource=datasource;
	}

	@Override
	public List<Customers> selectForList(Object key) throws SQLException {
		List<Customers> data = new ArrayList<>();
		Connection connection = datasource.getConnection();
		String sql="SELECT * FROM customer_list where country=?";
		PreparedStatement st=connection.prepareStatement(sql);
		st.setObject(1, key);
		ResultSet rs=st.executeQuery();
		while(rs.next()){
			Customers customers = new Customers();
			customers.setId(rs.getShort("ID"));
			customers.setName(rs.getString("name"));
			customers.setAddress(rs.getString("address"));
			customers.setPhone(rs.getString("phone"));
			customers.setCountry(rs.getString("country"));
			data.add(customers);		
		}
		connection.close();
		return data;
	}
	
	

}
