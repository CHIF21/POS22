package math_tester;

public class Math_Tester {
    public static void main(String[] args) {
        int x = 2;
        int y = -5;

        System.out.format("abs(%d) = %d\n", y, Math.abs(y));
        System.out.format("%d^%d = %.2f\n", y, x, Math.pow(x, y));
        System.out.format("PI = %.10f\n", Math.PI);
    }
}
