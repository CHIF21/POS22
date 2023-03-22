public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getDenominator() {
        return denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void cancel() {

        if(denominator == 0) {
            throw new ArithmeticException("Du kannst nicht durch 0 dividieren!");
        }

        int a = numerator;
        int b = denominator;

        do {
            while(a > b) {
                a -= b;
            }

            while(a < b) {
                b -= a;
            }

        } while(a != b);

        int help = a;

        numerator /= help;
        denominator /= help;
    }
}
