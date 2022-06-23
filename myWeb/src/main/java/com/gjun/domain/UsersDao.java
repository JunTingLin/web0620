package com.gjun.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.gjun.beans.Users;

public class UsersDao implements IDao<Users>{
	private DataSource datasource;
	
	@Override
	public boolean insert(Users users) throws SQLException {
		boolean r =false;
		Connection connection = null;
		try {
			connection = datasource.getConnection();
			String sql = "INSERT INTO javausers(username,password,realname,email) VALUES(?,?,?,?)";
			PreparedStatement st =connection.prepareStatement(sql);
			st.setString(1, users.getUserName());
			st.setString(2, users.getPassword());
			st.setString(3, users.getRealName());
			st.setString(4, users.getEmail());
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

	@Override
	public void setDataSource(DataSource datasource) {
		this.datasource=datasource;
		
	}
	
}