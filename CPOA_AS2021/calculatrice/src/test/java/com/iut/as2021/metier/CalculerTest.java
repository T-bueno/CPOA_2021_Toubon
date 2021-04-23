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
	public void testCasAdditionAvancée() throws MathsExceptions {
		assertEquals(calcul.run("8 + 2 + 5 + 4"), 19, 1);
	}

	@Test
	public void testCasSoustractionAvancée() throws MathsExceptions {
		assertEquals(calcul.run("10 - 2 - 5 - 1"), 2, 1);
	}

	@Test
	public void testCasAdditionSoustractionAvancée() throws MathsExceptions {
		assertEquals(calcul.run("15 - 5 + 2 -1 + 5"), 16, 1);
	}

	@Test
	public void testCasMultiplicationSimple() throws MathsExceptions {
		calcul.setMaths(mathsMock);
		Mockito.when(mathsMock.multiplication(anyInt(), anyInt())).thenReturn(6);
		assertEquals(calcul.run("7 * 1"), 6, 1);
	}
}