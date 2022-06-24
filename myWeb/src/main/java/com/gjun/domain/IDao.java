package com.gjun.domain;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

public interface IDao<T> {
	public default boolean insert(T entity) throws SQLException{
		return true;
	}
	public default T selectForObject(Object key) throws SQLException{
		return null;
	}
	public default boolean selectForObject(Object key1, Object key2) throws SQLException{
		return false;
	}
	public default List<T> selectForList(Object key) throws SQLException{
		return null;
	}
	public void setDataSource(DataSource datasource);
}
