package com.gjun.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.gjun.beans.MyCustomers;

public class MyCustomersDao implements IDao<MyCustomers>{

	private DataSource dataSource;
	@Override
	public void setDataSource(DataSource datasource) {
		this.dataSource=datasource;
		
	}

	public DataSource getDataSource() {
		return dataSource;
	}


	@Override
	public boolean insert(MyCustomers customers) throws SQLException {
		boolean r =false;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			String sql = "INSERT INTO javacustomers(customerid,companyname,address,phone,email,country) VALUES(?,?,?,?,?,?)";
			PreparedStatement st =connection.prepareStatement(sql);
			st.setString(1, customers.getCustomerId());
			st.setString(2, customers.getCompanyName());
			st.setString(3, customers.getAddress());
			st.setString(4, customers.getPhone());
			st.setString(5, customers.getEmail());
			st.setString(6, customers.getCountry());
			int rs = st.executeUpdate();
			r=true;
		} catch (SQLException e) {
			throw e;
		} finally {
			if(connection!=null) {
				connection.close();
			}
		}
		return r;
	}
	
	

}