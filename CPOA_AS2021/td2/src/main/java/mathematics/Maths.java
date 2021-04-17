package mathematics;

import exceptions.MathsExceptions;
import exceptions.MathsExceptions;
import interfaces.IMaths;

public class Maths implements IMaths {

    @Override
    public int addition(Integer a, Integer b){
        return a+b;
    }

    @Override
    public int soustraction (Integer a, Integer b){
        return a-b;
    }



    @Override
    public int multiplication (Integer a, Integer b) throws MathsExceptions {
        if (a == null || b == null) {
            System.out.println("Multiplication d'un nul impossible !");
            throw new MathsExceptions("Multiplication d'un nul impossible !");
        }
        int res = 0;

        if ( b > 0){
            for (int i = 0; i < b; i++){
                res = addition(res,a);
            }
        }else if (a > 0){
            for (int i = 0; i < a; i++){
                res = addition(res,b);
            }
        }else {
            for (int i = 0; i < -b; i++){
                res = addition(res,a);
            }
            res = -res;
        }
        return res;
    }

    @Override
    public double division (Integer a, Integer b) throws MathsExceptions {
        if (a == null || b == null) {
            System.out.println("Division d'un nul impossible !");
            throw new MathsExceptions("Division d'un nul impossible !");
        }
        try {
            return a/b;
        } catch (ArithmeticException e){

            System.out.println("Divsion par 0 impossible !");
            System.out.println(e.getMessage());
            throw new MathsExceptions(e.getMessage());
        }
    }
}
