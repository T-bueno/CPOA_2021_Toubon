package com.iut.as2021.tools;

public class brouillonIutTools {

    public static String getLeftExpression(String expression, int IndexOperator) {
        return expression.substring(0, IndexOperator).trim();
    }

    public static String getRightExpression(String expression, int pos) {
        String res = "";

        for (int i = 0; i < expression.length(); i++){

        }

        return res;
    }

    public static String getLastLeftExpression(String expression, int IndexOperator) {
        String res = "";


        return res;
    }

    public static String getNextRightExpression(String expression, int pos) {

        return expression.substring(pos + 1).trim();
    }

    public static char getNextOperator(String expression, int pos) {
        for (int i = pos+1; i < expression.length(); i++){
            char c = expression.charAt(i);
            if (c == 42 || c == 47){
                return c;
            }
        }
        for (int i = pos+1; i < expression.length(); i++){
            char c = expression.charAt(i);
            if (c == 43 || c == 45){
                return c;
            }
        }
        return 32;
    }

    public static int getPosNextOperator(String expression, int pos) {
        for (int i = pos+1; i < expression.length(); i++){
            char c = expression.charAt(i);
            if (c == 42 || c == 47){
                System.out.println("Il y a un * ou / !!!");
                return i;
            }
        }
        for (int i = pos+1; i < expression.length(); i++){
            char c = expression.charAt(i);
            if (c == 43 || c == 45){
                System.out.println("Il n'y pas un * ou / !!!");
                return i;
            }
        }
        return 0;
    }


    public static String getNextEntier(String expression, int pos) {
        String res = "";

        String digitSaw = "";
        boolean sawNumber = false;
        int z = pos+1;
        while((z<expression.length()) && (!(sawNumber))){
            digitSaw = digitSaw + expression.charAt(z);
            System.out.println("        z = "+ expression.charAt(z));
            System.out.println("digitsaw = " + digitSaw);
            char c = expression.charAt(z);
            if (c == 32 && res != "") {
                return res;
            }
            else if (c > 47 && c < 58){
                if ((z > 1) && (expression.charAt(z-1) == 45) && ((expression.charAt(z-2) < 48 || expression.charAt(z-2) > 57))){
                    res = "-" + c;
                }
                else {
                    res = res + c;
                }
            }
            z++;
            System.out.println("                        sawNumber = " + sawNumber + " && digitSaw = " + digitSaw);
            sawNumber = sawNumber(digitSaw, 1);
        }
        System.out.println("                    APRES LE while Next res = " + res);
        System.out.println("                        sawNumber = " + sawNumber + " && digitSaw = " + digitSaw);
        res = "";


        for (int i = pos; i < expression.length(); i++){
            char c = expression.charAt(i);
            if (c == 32 && res != "") {
                return res;
            }
            else if (c > 47 && c < 58){
                if ((i > 1) && (expression.charAt(i-1) == 45) && ((expression.charAt(i-2) < 48 || expression.charAt(i-2) > 57))){
                    res = "-" + c;
                    return res;
                }
                else {
                    res = "" + c;
                    return res;
                }
            }
        }
        return res;
    }

    public static String getLastEntier(String expression, int pos){
        String res = "";


        String digitSaw = "";
        boolean sawNumber = false;
        int z = pos-1;
        while((z>0) && (!(sawNumber))){
            digitSaw = digitSaw + expression.charAt(z);
            System.out.println("                    DANS LE WHILE car z="+z+"<"+expression.length()+"&& sawNumber(expression, pos) is false? =>"+ sawNumber(digitSaw, 0));
            char c = expression.charAt(z);
            System.out.println("            Rencontre un c="+c);
            if (c == 32 && res != "") {
                return res;
            }
            else if (c > 47 && c < 58){
                if ((z > 1) && (expression.charAt(z-1) == 45) && ((expression.charAt(z-2) < 48 || expression.charAt(z-2) > 57))){
                    System.out.println("Rencontre un negatif");
                    res = "-" + c;
                }
                else {
                    System.out.println("Rencontre un positif");
                    res = res + c;
                }
            }
            z--;
            sawNumber = sawNumber(digitSaw, 0);
        }
        System.out.println("                    APRES LE WHILE lastv v res = " + res);
        return res;




        /*
        res = "";




        for (int i = pos; i >= 0; i--){
            char c = expression.charAt(i);
            if (c == 32 && res != "") {
                return res;
            }
            else if (c > 47 && c < 58){
                if ((i > 2) && (expression.charAt(i-1) == 45) && ((expression.charAt(i-2) < 48 || expression.charAt(i-2) > 57))) {
                    res = "-" + c + res;

                }
                else if ((i == 1) && (expression.charAt(i-1) == 45)){
                    res = "-" + c + res;
                }
                else {
                    res = c + res;
                }
            }
        }
        return res;

         */
    }

    public static String getNextOperation (String expression) {
        String res = "";
        int pos = 0;

        char operand = getNextOperator(expression, pos);
        System.out.println("operand = " + operand);

        pos = IutTools.getPosNextOperator(expression, pos);
        System.out.println("pos = " + pos);

        String right = getNextEntier(expression, pos);
        System.out.println("getNextOperation --> right = " + right);
        String left = getLastEntier(expression, pos);
        System.out.println("getNextOperation --> left = " + left);

        res = (left + operand + right);

        return res;
    }

    public static boolean sawNumber(String expression, int pos){
        boolean number = false;
        for (int i = pos; i<expression.length(); i++){
            if (expression.charAt(i) > 47 && expression.charAt(i) < 58){
                number = true;
            }else if ((expression.charAt(i) < 48) || (expression.charAt(i) > 57) && (number)){
                return true;
            }
        }
        return false;
    }
}