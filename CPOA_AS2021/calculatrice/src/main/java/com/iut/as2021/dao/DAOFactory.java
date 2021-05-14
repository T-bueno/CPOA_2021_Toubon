package com.iut.as2021.dao;

import com.iut.as2021.metier.MathResultat;

public abstract class DAOFactory {
	
	public static DAOFactory getDAOFactory(Persistance cible) {
		
		DAOFactory daoF = null;
		
		switch (cible) {
		    case MYSQL:
		    	daoF = new MySQLDAOFactory();
		    	break;
		}
		
		return daoF;
	}
	
	public abstract MathResultatDAO<MathResultat> getMathResultatDAO();



}
