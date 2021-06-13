package com.iut.as2021.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.metier.MathResultat;

@SuppressWarnings("hiding")
public interface MathResultatDAO<MathResultat> extends DAO<MathResultat> {
	
	public ArrayList<MathResultat> findAll() throws SQLException, MathsExceptions;

}
