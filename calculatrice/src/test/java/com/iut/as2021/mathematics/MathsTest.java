package com.iut.as2021.mathematics;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.interfaces.IMaths;

public class MathsTest {

	private IMaths maths;


	@Before
	public void setUp() {
		this.maths = new Maths();
	}

	@Test
	public void testAdditionCasGeneralNombresPositifs() {
		Assert.assertEquals(maths.addition(2, 3), 5);
	}

	@Test
	public void testSoustractionCasGeneralNombrePositif() {
		Assert.assertEquals(maths.soustration(8, 3), 5);
	}

	@Test
	public void testMultiplicationCasGeneralNombrePositif() {
		Assert.assertEquals(maths.multiplication(4, 2), 8);
	}

	@Test
	public void testDivisionCasGeneralNombrePositif() throws MathsExceptions {
		Assert.assertEquals(maths.division(10, 5), 2, 2);
	}

	@Test
	public void testAdditionCasGeneralNombreNegatif() {
		Assert.assertEquals(maths.addition(-2, -4), -6);
	}

	@Test
	public void testSoustractionCasGeneralNombreNegatif() {
		Assert.assertEquals(maths.soustration(-3, -1), -2);
	}

	@Test
	public void testMultiplicationCasGeneralNombreNegatif() {
		Assert.assertEquals(maths.multiplication(-2, -4), 8);
	}

	@Test
	public void testDivisionCasGeneralNombreNegatif() throws MathsExceptions {
		Assert.assertEquals(maths.division(-10, -5), 2, 2);
	}

	@Test
	public void testAdditionCasGeneralNombresPositifNegatif() {
		Assert.assertEquals(maths.addition(-1, 5), 4);
	}

	@Test
	public void testSoustractionCasGeneralNombresPositifNegatif() {
		Assert.assertEquals(maths.soustration(-2, 8), -10);
	}

	@Test
	public void testMultiplicationCasGeneralNombresPositifNegatif() {
		Assert.assertEquals(maths.multiplication(-2, 4), -8);
	}

	@Test
	public void testDivisionCasGeneralNombresPositifNegatif() throws MathsExceptions {
		Assert.assertEquals(maths.division(-10, 5), -2, 2);
	}

	@Test
	public void testAdditionCasGeneralZero() {
		Assert.assertEquals(maths.addition(0, 0), 0);
	}

	@Test
	public void testSoustractionCasGeneralZero() {
		Assert.assertEquals(maths.soustration(0, 0), 0);
	}

	@Test
	public void testMultiplicationCasGeneralZero() {
		Assert.assertEquals(maths.multiplication(0, 0), 0);
	}

	@Test
	public void testAdditionCasGeneralPositifZero() {
		Assert.assertEquals(maths.addition(8, 0), 8);
	}

	@Test
	public void testSoustractionCasGeneralPositifZero() {
		Assert.assertEquals(maths.soustration(8, 0), 8);
	}

	@Test
	public void testMultiplicationCasGeneralPositifZero() {
		Assert.assertEquals(maths.multiplication(8, 0), 0);
	}

	@Test
	public void testDivisionCasGeneralPositifZero() throws MathsExceptions {
		Assert.assertEquals(maths.division(0, 8), 0, 2);
	}

	@Test
	public void testAdditionCasGeneralNegatifZero() {
		Assert.assertEquals(maths.addition(-8, 0), -8);
	}

	@Test
	public void testSoustractionCasGeneralNegatifZero() {
		Assert.assertEquals(maths.soustration(-8, 0), -8);
	}

	@Test
	public void testMultiplicationCasGeneralNegatifZero() {
		Assert.assertEquals(maths.multiplication(-8, 0), 0);
	}



	@Test(expected = MathsExceptions.class)
	public void testDivisionParZero() throws MathsExceptions {
		try {
			maths.division(4, 0);
		} catch (MathsExceptions e) {
			Assert.assertEquals(e.getMessage(),"DIvision par zero impossible");
			throw e;
		}
	}



}
