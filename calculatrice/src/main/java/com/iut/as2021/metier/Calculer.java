package com.iut.as2021.metier;

import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.interfaces.IMaths;
import com.iut.as2021.tools.IutTools;

public class Calculer {

	private IMaths maths;

	public void setMaths(IMaths maths) {
		this.maths = maths;
	}

	public Calculer(IMaths maths) {
		this.setMaths(maths);
	}


	private int applyOperator(char operand, int firstNum, int secondNum) throws MathsExceptions {
		int res = 0;

		for (int i = 0; i<4 ;i++ ){
			if (operand == '*'){
				res = maths.multiplication(firstNum, secondNum);
			}else if (operand == '+'){
				res = maths.addition(firstNum, secondNum);
			}else{
				res = maths.soustration(firstNum, secondNum);
			}
		}
		return res;
	}

	public static char getNextOperation(String expression, int pos) {
		for (int i = pos; i < expression.length(); i++){
			char c = expression.charAt(i);
			if (c == 42 || c == 43 || c == 45 || c == 47){
				return c;
			}
		}
		return 32;
	}

	public static String getNextEntier(String expression, int pos) {
		String res = "";
		for (int i = pos; i < expression.length(); i++){
			char c = expression.charAt(i);
			if (c == 32 && res != "") {
				return res;
			}
			if (c > 47 && c < 58) {
				res += c;
			}
		}
		return res;
	}

	public double run(String expression) throws MathsExceptions {
		int pos = 0;

		char operand = getNextOperation(expression, pos);

		pos = expression.indexOf(operand);

		String left = IutTools.getLeftExpression(expression, pos);

		String right = IutTools.getRightExpression(expression, pos);

		int result = Integer.valueOf(left);

		while (operand != 32) {
			pos = expression.indexOf(operand, pos);
			right = getNextEntier(expression, pos);
			result = applyOperator(operand, result, Integer.valueOf(right));
			pos += 1;
			operand = getNextOperation(expression, pos);
		}
		return result;
	}
}
