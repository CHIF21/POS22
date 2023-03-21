import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class EulerBL {
    public static int multiplesOf3_5(int number) {
        if (number % 3 == 0 || number % 5 == 0) {
            return number;
        }
        return 0;
    }

    public static int triplet() {
        // [a < b < c]!!
        int a = 1;
        double b;
        int c = 0;
        do {
            b = 1000.00 * (500 - a) / (1000 - a); // herausfinden von der unbekannten b
            if (b == (int) b && b > 0) { // Überprüfung ob (double) b == (int) b nachdem das Ergebnis gefunden wurde, wird die Schleife abgebrochen.
                c = 1000 - a - (int) b; // umgeformt von a + b + c = 1000 /-> a + b + c = 1000 | -c / +1000
                break;
            }
            a++;
        } while(a < 1000);
        // Wenn 1000 das Produkt von a \* b \* c sein soll und man den Satz vom Pytahgoras anwendet, sollte a = 200, b = 375 c = 425 => 1000 rauskommen
        System.out.format("A: %d B: %d C: %d", a, (int) b, c);
        return a * (int) b * c;
    }

    public static BigInteger factorial(BigInteger number) {
        BigInteger fact = new BigInteger("1");
        BigInteger result = new BigInteger("0");
        for(int i = 1; i <= number.intValue(); i++) {
            result = fact.multiply(new BigInteger(String.valueOf(i))); // If you use division or mulitplication it is important
            fact = result;                                             // to save it in a variable, because BigInteger is immutable (unveränderlich)
            // System.out.println(i + " Fact: " + result);
        }
        return result;
    }

    public static int digitSum(BigInteger number) {
        int sum = 0;
        BigInteger result;
        while(number.compareTo(BigInteger.ZERO) > 0) {
            sum += number.mod(BigInteger.TEN).intValue();
            result = number.divide(BigInteger.TEN);
            number = result;
            // System.out.println("DigitSum: " + sum);
        }
        return sum;
    }

    public static int[] lexicographeSort(int[] number) {
        int n = number.length;
        int k = 1_000_000;
        int[] result = new int[n];
        int[] factor = getFactorials(n - 1);

        for (int i = n - 1; i >= 0; i--) {
            int index = (k - 1) / factor[i];
            result[n - 1 - i] = number[index];
            for (int j = index; j < n - 1; j++) {
                number[j] = number[j + 1];
            }
            k -= index * factor[i];
        }

        return result;
    }

    private static int[] getFactorials(int n) {
        int[] factor = new int[n + 1];
        factor[0] = 1;
        for (int i = 1; i <= n; i++) {
            factor[i] = factor[i - 1] * i;
        }
        return factor;
    }

    public static BigInteger selfPower() {
        BigInteger sum = new BigInteger("0");
        BigInteger number;
        BigInteger result;
        for(int i = 1; i <= 1000; i++) {
            number = new BigInteger(String.valueOf(i));
            result = sum.add(number.pow(i));
            sum = result;
        }
        return sum;
    }
}
