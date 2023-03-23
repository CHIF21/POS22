package exceptionErrors;

import java.util.Scanner;

public class SimpleCalculator {
    private int value;

    public SimpleCalculator(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void calculate() throws Exception {
        // Our calculation does not accept a 1
        if(value == 1) {
            // -> Problem
            throw new Exception("Value 1 is not allowed");
            // Exception is a "checked exception", that means:
            // 1. At the signature of the method, there must be specified
            // "throws Exception"
            // 2. The call of this method, must be inside a try block.
            // Examples: Exception, IOException, ...
        }

        value *= 2;
    }

    public void divide(int divisor) {
        if(divisor == 0) {
            throw new ArithmeticException("Divison  by zero!");
            // "unchecked exceptions": point 1. and 2. are not needed
            // Examples: NumberFormatException, ArithmeticException, RuntimeException, ...
        }

        value /= divisor;
    }
}
