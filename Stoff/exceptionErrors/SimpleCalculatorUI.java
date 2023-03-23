package exceptionErrors;

import java.util.Scanner;

public class SimpleCalculatorUI {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        SimpleCalculator sc = new SimpleCalculator(0);

        for(int i = 0; i < 3; i++) {
            System.out.print("Enter your number: ");
            String strNumber = scan.next();

            try {
                // String -> int: Be careful, there might be a problem
                int number = Integer.parseInt(strNumber);
                System.out.println("Your number is : " + number);
                sc.setValue(number);
                sc.calculate();

                sc.divide(0);
            } catch (NumberFormatException ex) {
                // This is never empty
                // System.out.println("This cannot be parsed!");
                // ex.printStackTrace();
                System.out.println(ex.getMessage());
            } catch(ArithmeticException ex) {
                System.out.println(ex.getMessage());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
