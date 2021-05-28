package com.iut.as2021.dao;

public class MySQLDAOFactory extends DAOFactory {
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public MathResultatDAO getMathResultatDAO() {
		
		return MySQLMathResultatDAO.getInstance();
		
	}

}
