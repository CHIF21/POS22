package operators_controlstructures_tester;

public class OperatorsANDControlStructures {
    public static void main(String[] args) {

        /*
        unary operators:
            unary sign operators: +, -
            unary arithmetic operators: ++, --
        arithmetic operators: +, -, *, /, %
        assignment operators: =. +=, -=, *=, /=, %= (...)
        comparison operators: ==, !=, >, <, >=, <=
        logical operators: &&, ||, !, (&, |, ^)
        (bitwise coperators: &, |, ^, ~, !)

        ternary operator: ? : (conditional operator)
        */

        int a = 3;
        String txt = a  >= 0 ? "positive" : "negative";
        System.out.format("The number is %s.\n", txt);

        // control structures
        // if, if - else, if - else if - else if - else
        a = 0;
        if(a > 0) {
            System.out.println("Number is negative.");
        } else if(a < 0) {
            System.out.println("Number is positive.");
        } else {
            System.out.println("Number is zero.");
        }

        // switch-statement
        switch (a) {
            case 0:
                System.out.println("zero"); break;
            case 1:
                System.out.println("one"); break;
            case 2:
                System.out.println("two"); break;
            default:
                System.out.println("other number");
        }

        // for-loop:
        for (int i = 0; i < 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println(

        );

        // while-loop
        int j = 0;
        while(j < 5) {
            System.out.print(j + " ");
            j++;
        }
        System.out.println();

        // do-while
        int k = 0;
        do {
            System.out.print(k + " ");
            k++;
        } while(k < 5);
        System.out.println();
    }
}
