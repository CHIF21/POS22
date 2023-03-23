package vararg_tester;

public class VarArguments_Tester {

    // calculate-Methode
    public double calc(double factor, int a, int b) {
        return (a + b) * factor;
    }

    public double calc(double factor, int a, int b, int c) {
        return (a + b + c) * factor;
    }

    public double calc(double factor, double a, double b) {
        return (a + b) * factor;
    }

    public double calc(double factor, int... numbers) {
        int digitSum = 0;
        for(int i = 0; i < numbers.length; i++) {
            digitSum += numbers[i];
        }
        return digitSum * factor;
    }

    public static void main(String[] args) {
        VarArguments_Tester tester = new VarArguments_Tester();

        System.out.println(tester.calc(2.5, 2, 3));
        System.out.println(tester.calc(1.5, 2, 3, 4));
        System.out.println(tester.calc(1.5, 1.5, 3.8));
        System.out.println(tester.calc(1.5, 1, 2, 3, 4, 5));
    }
}
