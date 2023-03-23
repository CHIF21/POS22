package io_tester;

import java.util.Scanner;

public class IO_Tester {
    public static void main(String[] args) {

        // output of text
        System.out.println("Hello World");
        System.out.print("Nice");
        System.out.println(" to meet you.");

        // output of different values
        int intNumber = 217;
        double doubleNumber = 123.56789;
        char letter = 'A';
        String text = "Das ist ein Text";
        // not formatted output
        System.out.println(intNumber + " " + doubleNumber + " " + letter + " " + text);

        // formatted output
        System.out.format("%-6d %-10.3f %-6c %s\n", intNumber, doubleNumber, letter, text);

        // input of text and different values
        Scanner scan = new Scanner(System.in);

        System.out.print("your text: ");
        text = scan.nextLine();
        System.out.println(text);

        System.out.print("your int value: ");
        intNumber = scan.nextInt();
        System.out.println(intNumber);

        try {
            System.out.print("your double value: ");
            doubleNumber = scan.nextDouble();
            System.out.println(doubleNumber);
        } catch (Exception e) {
            System.out.println("Sie dürfen kein Punkt als Komma nehmen!");
        }

        System.out.print("your char value: ");
        letter = scan.nextLine().charAt(0);
        System.out.println(letter);
    }
}
