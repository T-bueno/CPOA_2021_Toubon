package com.iut.as2021.mathematics;

import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.interfaces.IMaths;

public class Maths implements IMaths {

	@Override
	public int addition(int a, int b) {
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("res = " + (a+b));

		return a + b;
	}

	@Override
	public int soustration(int a, int b) {
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("res = " + (a-b));
		return a - b;
	}

	@Override
	public int multiplication(int a, int b) {
		// Ecrire l'implementation de multiplication en utilisant que des additions !
		// Tester tous les cas possibles (positifs, negatifs, 0 ...).
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("res = " + (a*b));
		return a * b;
	}

	@Override
	public double division(int a, int b) throws MathsExceptions {
		if (b == 0) {
			throw new MathsExceptions("Division par zero impossible");
		}
		try {
			System.out.println("a = " + a);
			System.out.println("b = " + b);
			System.out.println("res = " + (a/b));
			return a / b;
		} catch (Exception e) {
			throw new MathsExceptions(e.getMessage());
		}
	}
}
