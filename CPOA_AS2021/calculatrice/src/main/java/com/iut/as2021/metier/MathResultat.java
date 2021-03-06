package com.iut.as2021.metier;

import com.iut.as2021.enumerations.EOperation;
import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.interfaces.IMaths;
import com.iut.as2021.mathematics.Maths;

import static com.iut.as2021.enumerations.EOperation.*;

/**
 * Classe récursive permettant de créer un arbre binaire d'opérations.
 *
 * @author stephane.joyeux
 *
 */

public class MathResultat {
    private EOperation operation;
    private IMaths maths;
    private String expression;
    private int resultat;
    private int id;

    private MathResultat leftExpression;

    private MathResultat rightExpression;

    public EOperation getOperation() {
        return operation;
    }

    public double getValue() throws MathsExceptions {
        if (INCONNUE.equals(operation)) {
            return Integer.valueOf(expression);
        }
        return calculate();
    }

    public MathResultat getLeftExpression() {
        return leftExpression;
    }

    public MathResultat getRightExpression() {
        return rightExpression;
    }

    public MathResultat(String expression) {
        this.operation = INCONNUE;
        this.expression = expression;
        switchLeftAndRightExpression();
        this.maths = new Maths();
    }
    
    public MathResultat(String expression, int resultat) {
        this(expression);
        this.setResultat(resultat);
    }
    
    public MathResultat(String expression, int resultat, int id) {
        this(expression,resultat);
        this.setId(id);
    }
    

    protected double calculate() throws MathsExceptions {
        if (!INCONNUE.equals(operation)) {
            double leftValue = leftExpression.getValue();
            double rigthValue = rightExpression.getValue();
            switch (operation) {
                case ADDITION:
                    return maths.addition((int) leftValue, (int) rigthValue);
                case SOUSTRACTION:
                    return maths.soustration((int) leftValue, (int) rigthValue);
                case MULTIPLICATION:
                    return maths.multiplication((int) leftValue, (int) rigthValue);
                case DIVISION:
                    return maths.division((int) leftValue, (int) rigthValue);
                default:
                    return 0;
            }
        }
        return 0;
    }

    private void switchLeftAndRightExpression() {
        int pos = getPosition();
        if (!INCONNUE.equals(operation) && pos > 0) {
            leftExpression = new MathResultat(getLeftExpression(expression, pos));
            rightExpression = new MathResultat(getRightExpression(expression, pos));
        }
    }

    private int getPosition() {
        int pos = getPositionFromOperation(ADDITION);
        if (pos <= 0) {
            pos = getPositionFromOperation(SOUSTRACTION);
        }
        if (pos <= 0) {
            pos = getPositionFromOperation(MULTIPLICATION);
        }
        if (pos <= 0) {
            pos = getPositionFromOperation(DIVISION);
        }
        return pos;
    }

    private int getPositionFromOperation(EOperation operation) {
        int pos = this.expression.indexOf(operation.getOperateur());
        if (pos > 0) {
            this.operation = operation;
            return pos;
        }
        return 0;
    }

    private String getLeftExpression(String expression, int pos) {
        return expression.substring(0, pos).trim();
    }
    private String getRightExpression(String expression, int pos) {
        return expression.substring(pos + 1).trim();
    }

	public int getResultat() {
		return resultat;
	}

	public void setResultat(int resultat) {
		this.resultat = resultat;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		if (expression==null || expression.trim().length() == 0) {
			throw new IllegalArgumentException("L'expression ne peut pas être vide !");
		}
		this.expression = expression;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
}
