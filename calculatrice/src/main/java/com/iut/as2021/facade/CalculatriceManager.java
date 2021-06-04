package com.iut.as2021.facade;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iut.as2021.dao.MathResultatDAO;
import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.metier.MathResultat;
import com.iut.as2021.dao.MySQLMathResultatDAO;

/**
 * Pattern facade : cacher la compléxité d'un code .. Permette sa réutilisation
 * aux autres classes sans avoir à dupliquer le code ..
 * 
 */
@Component
public class CalculatriceManager {

	@Autowired
	private MathResultatDAO dao;

	private MathResultat calculatrice;

	private static final Logger logger = Logger.getLogger(CalculatriceManager.class);

//	public CalculatriceManager() {
//		dao = MySqlDao.getInstance();
//		System.out.println("Auto - DAO IS NULL ? " + (dao == null));
//	}

	public CalculatriceManager(MathResultatDAO dao) {
		logger.debug("Manuel - DAO IS NOT NULL ? " + (dao instanceof MySQLMathResultatDAO));
		this.dao = dao;
	}

	// Pattern facade : on va cacher la complexité d'implémentation du code */
	public String calculer(String expression) throws MathsExceptions {
		try {
			this.calculatrice = new MathResultat(expression);
			String result = String.valueOf(calculatrice.calculate());
			logger.info("Manager resultat = " + result);
			return result;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new MathsExceptions(e.getMessage());
		}
	}

	public boolean saveResult() throws SQLException {
		// prévoir gestion des exceptions ..
		return dao.create(calculatrice);
	}
}
