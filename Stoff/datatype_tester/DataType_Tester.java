package datatype_tester;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Locale;

public class DataType_Tester {
    public static void main(String[] args) {

        /*
        byte (1 Byte): -128 bis 127
        short (2 Byte): -2^15 bis (2^15)-1
        int (4 Byte): -2^31 bis (2^31)-1
        long (8 Byte): -2^63 bis (2^63)-1

        float (4 Byte): 6 bis 7 Stellen Genauigkeit
        double (8 Byte): 16 bis 17 Stellen Genauigkeit

        char (2 Byte): -2^15 bis (2^15)-1 --> Unicode Zeichensatz

        boolean (1 Byte): true - false
         */

        byte b1 = 1;
        // byte b2 = 128; // too big -> compiler error
        byte b3 = (byte) (b1 + 1); // type cast necessary, because calculation is done with int-values

        short s1 = 123;

        // int i1 = 12345678910; // too big -> compiler error
        int i2 = 1_234_567_890; // use _ for structuring

        long l1 = 1234567891011121314L; // long literals have to end with L or l

        // hexadecimal numbers
        int i3 = 0xFF; // hex literals have a leading 0x
        System.out.println(i3);
        System.out.format("%X", i3);

        // octal numbers
        int i4 = 0777; // oct literals have a leading 0
        System.out.println(i4);
        System.out.format("%o", i4);

        float f1 = 1.5f; // float numbers end with f
        double d1 = 1.5;

        // output of currency
        double z = 1234567.89;
        // possiblility 1:
        System.out.format("%,.2f\n", z);
        System.out.format(Locale.GERMAN, "%,.2f\n", z);
        System.out.format(Locale.ENGLISH, "%,.2f\n", z);
        // possibility 2:
        DecimalFormat df = new DecimalFormat("###,###.##");
        System.out.println(df.format(z));

        //BigInteger for very big integer values
        BigInteger bi1 = new BigInteger("1234567890123456789012345345");
        BigInteger bi2 = new BigInteger("9834758934275032894562304956");
        BigInteger bi3 = bi1.add(bi2);
        System.out.println(bi3);

        // BigDecimal for very big decimal values
        BigDecimal bd1 = new BigDecimal("1231234.4124124124");
        System.out.println(bd1);
    }
}
