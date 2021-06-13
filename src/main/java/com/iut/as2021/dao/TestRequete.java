package com.iut.as2021.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.iut.as2021.tools.Saisie;
import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.metier.MathResultat;

public class TestRequete {

	
	
public static void main(String[] args) throws SQLException, MathsExceptions {
		
		testExpressions();
		
		DAOFactory daos = DAOFactory.getDAOFactory(Persistance.MYSQL);
		
		@SuppressWarnings("unused")
		ArrayList<MathResultat> expressions = daos.getMathResultatDAO().findAll();
		
		MathResultat m = new MathResultat ("4+3", 7, null);
		daos.getMathResultatDAO().create(m);

	}



private static void testExpressions() throws MathsExceptions {
	
	try {
		
		System.out.println("Get byId\n------------------------------");
		MathResultat e = MySQLMathResultatDAO.getInstance().getById(3);
		System.out.println(e.getExpression());

		System.out.println("\nfind all\n------------------------------");
		
		afficheExpressions();
		
		System.out.println("-----------------------------------\ncreate !");

		String Expression = Saisie.saisieChaine("Saisir une expression : ");
		int Resultat = Saisie.saisieEntier("Saisir un r�sultat : ");
		
		//String Expression = "2+1";
		//int Resultat = 3;
		//MathResultat eNew = new MathResultat("2+3",5);
		
		
		MathResultat eNew = new MathResultat(Expression,Resultat, null);
		if (!MySQLMathResultatDAO.getInstance().create(eNew)) {
			System.out.println("Echec de la creation !");
		}
		
		afficheExpressions();
		
        /*System.out.println("Update !\n---------------------------");
        ArrayList<MathResultat> listeExpression = MySQLMathResultatDAO.getInstance().findAll();

        int idExpression = Saisie.saisieEntier("Quelle expression modifier (choisir id de l'expresion) ? ");
        Expression = Saisie.saisieChaine("Saisir une nouvelle expression : ");
        Resultat = Saisie.saisieEntier("Saisir un nouveau r�sultat : ");
        listeExpression.get(idExpression).setExpression(Expression);
        listeExpression.get(idExpression).setResultat(Resultat);
        
        if (!MySQLMathResultatDAO.getInstance().update(listeExpression.get(idExpression))) {
            System.out.println("Echec de la modification !");
        }
        
        
		afficheExpressions();
		
		System.out.println("---------------------------------\nDelete !");
		
		idExpression = Saisie.saisieEntier("Quel expression supprimer (id) ? ");
		
		if (!MySQLMathResultatDAO.getInstance().delete(listeExpression.get(idExpression))) {
			System.out.println("Echec de la suppression !");
		} else {
			listeExpression.remove(idExpression);
		}

		// on affiche
		afficheExpressions();*/
	

	} catch (SQLException se) {
		System.out.println("Probleme SQL : " + se.getMessage());
	}

}
	
	
	
	private static void afficheExpressions() throws SQLException, MathsExceptions {
		
		ArrayList<MathResultat> listeExpressions = MySQLMathResultatDAO.getInstance().findAll();
		for (MathResultat elt : listeExpressions) {
			System.out.println(elt.getExpression());
		}
	}
	

}
