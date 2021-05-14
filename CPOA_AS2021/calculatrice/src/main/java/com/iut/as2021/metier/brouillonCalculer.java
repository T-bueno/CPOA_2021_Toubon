package com.iut.as2021.metier;

import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.interfaces.IMaths;
import com.iut.as2021.tools.IutTools;

public class brouillonCalculer {


    private IMaths maths;

    public void setMaths(IMaths maths) {
        this.maths = maths;
    }

    public brouillonCalculer(IMaths maths) {
        this.setMaths(maths);
    }


    private double applyOperator(char operand, int firstNum, int secondNum) throws MathsExceptions {
        double res = 0;

        if (operand == '*'){
            res = maths.multiplication(firstNum, secondNum);
        }else if (operand == '+'){
            res = maths.addition(firstNum, secondNum);
        }else if (operand == '-'){
            res = maths.soustration(firstNum, secondNum);
        }else {
            res = maths.division(firstNum, secondNum);
        }
        return res;
    }


    public double run(String expression) throws MathsExceptions {
        System.out.println("expression " + expression);
        expression = expression.replaceAll(" ","");
        System.out.println("expression " + expression);

        int pos = 0;

        String NextOperation = IutTools.getNextOperation(expression);
        System.out.println("NEXTOPERATION1 = " + NextOperation);

        char operand = IutTools.getNextOperator(NextOperation, pos);
        pos = IutTools.getPosNextOperator(NextOperation, pos);

        int right = Integer.valueOf(IutTools.getNextRightExpression(NextOperation, pos));
        int left = Integer.valueOf(IutTools.getLastEntier(NextOperation, pos));

        double result = applyOperator(operand, left, right);

        pos = NextOperation.length();


        int start = expression.indexOf(NextOperation);
        expression.replace(NextOperation,"");

        String expression1 = expression.substring(0,start);

        String expression2 = expression.substring(NextOperation.length());


        expression = expression1 + (int) result + expression2;


        if (IutTools.getPosNextOperator(expression, 0) > 0){
            result = run(expression);
        }

        return result;
    }
}
