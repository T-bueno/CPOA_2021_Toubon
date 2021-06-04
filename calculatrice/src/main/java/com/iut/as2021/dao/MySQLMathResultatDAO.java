package com.iut.as2021.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.iut.as2021.metier.MathResultat;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class MySQLMathResultatDAO implements MathResultatDAO<MathResultat> {
	
	private static MySQLMathResultatDAO instance;

	public static MySQLMathResultatDAO getInstance() {
		if (instance == null) {
			instance = new MySQLMathResultatDAO();
		}
		return instance;
	}

	private MySQLMathResultatDAO() {
	}
	
	
	public ArrayList<MathResultat> findAll() throws SQLException {
		
        ArrayList<MathResultat> liste = new ArrayList<>();

		
		String sql = "select * from operations";
		Connection co = ConnexionDAO.getInstance().getConnexion();
		
		Statement requete = co.createStatement();
		ResultSet res = requete.executeQuery(sql);
		while (res.next()) {
			liste.add(new MathResultat(res.getString(1), res.getInt(2)));
			
		}

		return liste;
		
	}

public boolean create(MathResultat e) throws SQLException {
		
	String sql = "insert into operations (expression, resultat, id) values (?, ?, ?)"; 
	
	Connection co = ConnexionDAO.getInstance().getConnexion();
	PreparedStatement requete = co.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	requete.setString(1, e.getExpression());
	requete.setInt(2, e.getResultat());
	requete.setInt(3, e.getId());
	
	int nbLignes = requete.executeUpdate();
	
	return (nbLignes==1);
	}

public boolean update(MathResultat e) throws SQLException {
	
	String sql = "update operations set expression=?, resultat=? where id=?";
	
	Connection co = ConnexionDAO.getInstance().getConnexion();
	PreparedStatement requete = co.prepareStatement(sql);
	requete.setString(1, e.getExpression());
	requete.setInt(2, e.getResultat());
	requete.setInt(3, e.getId());
	
	int nbLignes = requete.executeUpdate();
	
	return (nbLignes==1);
}

public boolean delete(MathResultat e) throws SQLException {
	
	String sql = "delete from operations where id=?";
	
	Connection co = ConnexionDAO.getInstance().getConnexion();
	PreparedStatement requete = co.prepareStatement(sql);
	requete.setString(1, e.getExpression());
	int nbLignes = requete.executeUpdate();
	
	return (nbLignes==1);
}

public MathResultat getById(int id) throws SQLException {

	MathResultat expression = null;

	String sql = "select * from operations where id = ?";
	Connection co = ConnexionDAO.getInstance().getConnexion();

	PreparedStatement requete = co.prepareStatement(sql);
	requete.setInt(1, id);
	ResultSet res = requete.executeQuery();
	if (res.next()) {
		expression = new MathResultat(res.getString(1), res.getInt(2));
	}

	return expression;
	}
}


