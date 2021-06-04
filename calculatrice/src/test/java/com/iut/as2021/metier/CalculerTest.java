package com.iut.as2021.metier;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;

import com.iut.as2021.exceptions.MathsExceptions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.iut.as2021.interfaces.IMaths;
import com.iut.as2021.mathematics.Maths;



public class CalculerTest {

	private Calculer calcul;
	private IMaths mathsMock;

	@Before
	public void setUp() {
		calcul = new Calculer(new Maths());
		mathsMock = Mockito.mock(Maths.class);
	}

	@Test
	public void testCasAdditionSimple() throws MathsExceptions {
		assertEquals(calcul.run("2 + 3"), 5, 1);
	}

	@Test
	public void testCasSoustractionSimple() throws MathsExceptions {
		assertEquals(calcul.run("2 - 3"), -1, 1);

	}

	@Test
	public void testCasAdditionAvance() throws MathsExceptions {
		assertEquals(calcul.run("8 + 2 + 5 + 4"), 19, 1);
	}

	@Test
	public void testCasSoustractionAvance() throws MathsExceptions {
		assertEquals(calcul.run("10 - 2 - 5 - 1"), 2, 1);
	}

	@Test
	public void testCasAdditionSoustractionAvance() throws MathsExceptions {
		assertEquals(calcul.run("15 - 5 + 2 -1 + 5"), 16, 1);
	}

	@Test
	public void testCasMultiplicationSimple() throws MathsExceptions {
		calcul.setMaths(mathsMock);
		Mockito.when(mathsMock.multiplication(anyInt(), anyInt())).thenReturn(6);
		assertEquals(calcul.run("7 * 1"), 6, 1);
	}
	
	@Test
	public void testMultiplicationCasGeneralNombrePositif() throws MathsExceptions {
		assertEquals(calcul.run("4 * 2"), 8, 1);
	}
	@Test
	public void testDivisionCasGeneralNombrePositif() throws MathsExceptions {
		assertEquals(calcul.run("10 / 5"), 2, 1);
	}

	@Test
	public void testAdditionCasGeneralNombreNegatif() throws MathsExceptions {
		assertEquals(calcul.run("-2 + -4"), -6, 1);
	}
	@Test
	public void testSoustractionCasGeneralNombreNegatif() throws MathsExceptions {
		assertEquals(calcul.run("-3 - -1"), -2, 1);
	}
	@Test
	public void testMultiplicationCasGeneralNombreNegatif() throws MathsExceptions {
		assertEquals(calcul.run("-2 * -4"), 8, 1);
	}
	@Test
	public void testDivisionCasGeneralNombreNegatif() throws MathsExceptions {
		assertEquals(calcul.run("-10 / -5"), 2, 1);
	}
	@Test
	public void testAdditionCasGeneralNombresPositifNegatif() throws MathsExceptions {
		assertEquals(calcul.run("-1 + 5"), 4, 1);
	}
	@Test
	public void testSoustractionCasGeneralNombresPositifNegatif() throws MathsExceptions {
		assertEquals(calcul.run("-2 - 8"), -10,1);
	}

	@Test
	public void testMultiplicationCasGeneralNombresPositifNegatif() throws MathsExceptions {
		assertEquals(calcul.run("-2 * 4"), -8,1);
	}
	@Test
	public void testDivisionCasGeneralNombresPositifNegatif() throws MathsExceptions {
		assertEquals(calcul.run("-10 / 5"), -2, 1);
	}
	@Test
	public void testAdditionCasGeneralZero() throws MathsExceptions {
		assertEquals(calcul.run("0 + 0"), 0,1);
	}
	@Test
	public void testSoustractionCasGeneralZero() throws MathsExceptions {
		assertEquals(calcul.run("0 - 0"), 0,1);
	}
	@Test
	public void testMultiplicationCasGeneralZero() throws MathsExceptions {
		assertEquals(calcul.run("0 * 0"), 0,1);
	}
	@Test
	public void testAdditionCasGeneralPositifZero() throws MathsExceptions {
		assertEquals(calcul.run("8 + 0"), 8,1);
	}
	@Test
	public void testSoustractionCasGeneralPositifZero() throws MathsExceptions {
		assertEquals(calcul.run("8 - 0"), 8,1);
	}
	@Test
	public void testMultiplicationCasGeneralPositifZero() throws MathsExceptions {
		assertEquals(calcul.run("8 * 0"), 0,1);
	}
	@Test
	public void testDivisionCasGeneralPositifZero() throws MathsExceptions {
		assertEquals(calcul.run("0 / 8"), 0, 1);
	}
	@Test
	public void testAdditionCasGeneralNegatifZero() throws MathsExceptions {
		assertEquals(calcul.run("-8 + 9"), 1,1);
	}
	@Test
	public void testSoustractionCasGeneralNegatifZero() throws MathsExceptions {
		assertEquals(calcul.run("-8 - 0"), -8,1);
	}
	@Test
	public void testMultiplicationCasGeneralNegatifZero() throws MathsExceptions {
		assertEquals(calcul.run("-8 * 0"), 0,1);
	}

	@Test
	public void testCasMultiplication() throws MathsExceptions {
		assertEquals(calcul.run("7 * -1"), -7, 1);
	}
	

	@Test
	public void testCasPrioriteMultiplication() throws MathsExceptions {
		assertEquals(calcul.run("10 - 2 * 3 + 1"), 5, 1);
	}

	/*

	@Test
	public void testCasMultiplicationSimple() throws MathsExceptions {
		calcul.setMaths(mathsMock);
		Mockito.when(mathsMock.multiplication(anyInt(), anyInt())).thenReturn(7);
		assertEquals(calcul.run("7 * 1"), 7, 1);
	}

	 */
}
