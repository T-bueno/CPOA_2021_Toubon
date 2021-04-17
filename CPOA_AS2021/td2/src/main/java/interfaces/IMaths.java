package interfaces;

import exceptions.MathsExceptions;

public interface IMaths {
    int addition (Integer a, Integer b);

    int soustraction (Integer a, Integer b);

    int multiplication (Integer a, Integer b) throws MathsExceptions;

    double division (Integer a, Integer b) throws MathsExceptions;
}
