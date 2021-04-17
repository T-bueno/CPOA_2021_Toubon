package main;

import exceptions.MathsExceptions;
import interfaces.IMaths;
import mathematics.Maths;

public class StartTestMaths {

    public static void main(String[] args) throws MathsExceptions {
        IMaths maths = new Maths();
        //System.out.println(maths.addition(2,3));

        //System.out.println(maths.soustraction(2,3));

        System.out.println(maths.multiplication(-5, -5));

        //System.out.println(maths.division(2,3));
    }
}
