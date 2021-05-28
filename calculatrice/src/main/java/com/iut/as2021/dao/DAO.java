package com.iut.as2021.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DAO<T> {
	
	public boolean create(T obj) throws SQLException;
	public boolean update(T obj) throws SQLException;
	public boolean delete(T obj) throws SQLException;
	public T getById(int id) throws SQLException;
	public ArrayList<T> findAll() throws SQLException;
	

}
