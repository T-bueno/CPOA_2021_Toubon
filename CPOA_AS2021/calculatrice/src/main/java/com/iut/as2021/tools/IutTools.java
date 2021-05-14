package com.iut.as2021.tools;

public class IutTools {

    public static String getLeftExpression(String expression, int pos) {
        return expression.substring(0, pos).trim();
    }

    public static String getRightExpression(String expression, int pos) {
        return expression.substring(pos + 1).trim();
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
        int z = pos;

        while((z<expression.length()) && (!(sawNumber))){
            System.out.println("INSIDE THE WHILE getNextentier: z="+z);
            System.out.println("    expression.lenght = "+ expression.length());

            char c = expression.charAt(z);
            System.out.println("    c = " + c);
            if (c == 32 && res != "") {
                System.out.println("!!!!!!!!!!  IL EST ENFIN RENTRE ICI");
            }
            else if (c > 47 && c < 58){
                if ((z > 1) && (expression.charAt(z-1) == 45) && ((expression.charAt(z-2) < 48 || expression.charAt(z-2) > 57))){
                    res = "-" + c;
                    System.out.println("res = " + res);
                }
                else {
                    res = res + c;
                    System.out.println("res = " + res);
                }
            }

            System.out.println("                        sawNumber = " + sawNumber + " && digitSaw = " + digitSaw);
            System.out.println("                        expression.charAt(z)  = " +  expression.charAt(z));
            digitSaw = digitSaw + expression.charAt(z);


            System.out.println("                        sawNumber = " + sawNumber + " && digitSaw = " + digitSaw);
            z++;
            sawNumber = sawNumber(digitSaw, 1);
            System.out.println("sawNumber = " + sawNumber);
        }
        System.out.println("Fin get Next entier res = " + res);
        return res;
    }

    public static String getLastEntier(String expression, int pos){
        String res = "";

        String digitSaw = "";
        boolean sawNumber = false;
        int z = pos-1;
        while((z>=0) && (!(sawNumber))){
            digitSaw = digitSaw + expression.charAt(z);
            char c = expression.charAt(z);
            if (c == 32 && res != "") {
                return res;
            }
            else if (c > 47 && c < 58){
                if ((z > 1) && (expression.charAt(z-1) == 45) && ((expression.charAt(z-2) < 48 || expression.charAt(z-2) > 57))){
                    res = "-" + c;
                }
                else {
                    res = c + res;
                }
            }
            z--;
            sawNumber = sawNumber(digitSaw, 0);
        }
        System.out.println("Fin get Next entier res = " + res);
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

        System.out.println("Avant getNextEntier");
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
            System.out.println("");
            System.out.println("DEBUT sawNumber:");
            System.out.println("expression = " + expression);



            System.out.println("    expression.charAt(i) = " + expression.charAt(i));
            System.out.println("number = " + number);
            if (expression.charAt(i) > 47 && expression.charAt(i) < 58){
                System.out.println("    JE SUIS RENTRE DANS LE IF (est un nombre) !!!");
                number = true;

            }else if ((expression.charAt(i) < 48) || (expression.charAt(i) > 57) && (number == true)){
                System.out.println("    JE SUIS RENTRE DANS LE ELSE IF (n'est pas un nb && en a déjà vu 1 ) !!!");
                return true;
            }
        }
        return false;
    }
    public static String deleteOperation(String expression, int start, int finish){
        String res = "" ;
        System.out.println("DEBUT deleteOperation");
        System.out.println("                     expression = " + expression);
        System.out.println("                     start = " + start);
        System.out.println("                     lengthExp = " + finish);
        for (int i = 0; i<expression.length(); i++){
            System.out.println("(i >= pos && i < lengthExp) ====> "+ i + " >= "+start + " && "+ i +" < " + finish);
            if ((i>= start) && (i < finish)){
            }else {
                System.out.println("I'm IN!!");
                System.out.println("Impression du resultat:");
                System.out.println("             AVANT           res = "+ res);
                res += expression.charAt(i);
                System.out.println("                APRES           res = "+ res);
            }
        }
        System.out.println("										RES ===> "+ res);
        return res;
    }

}
