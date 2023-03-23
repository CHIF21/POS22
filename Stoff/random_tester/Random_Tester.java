package random_tester;

import java.util.Random;

public class Random_Tester {
    public static void main(String[] args) {
        Random rand = new Random();
        // random integer values
        int iLoBo = 7;
        int iUpBo = 10;

        // any random integer number
        int r1 = rand.nextInt();
        System.out.println(r1);

        // random integer number within [0; iUpBo]
        int r2 = rand.nextInt(iUpBo + 1);
        System.out.println(r2);

        // random integer number within [iLoBo; iUpBo]
        int r3 = rand.nextInt(iLoBo, iUpBo);
        System.out.println(r3);

        // random double values
        double dLowerBound = 3.5;
        double dUpperBound = 10.0;
        double rDouble1 = rand.nextDouble();
        System.out.format("rDouble1 = %.2f\n", rDouble1);

        double rDouble2 = rand.nextDouble(dLowerBound);
        System.out.format("rDouble2 = %.2f\n", rDouble2);

        double rDouble3 = rand.nextDouble() * (dUpperBound - dLowerBound + 1) + dLowerBound;
        System.out.format("rDouble3 = %.2f\n", rDouble3);

        double rDouble4 = rand.nextDouble(dLowerBound, dUpperBound);
        System.out.format("rDouble4 = %.2f\n", rDouble4);

        //random boolean value
        boolean rBoolean = rand.nextBoolean();
        System.out.format("rBoolean = %s", rBoolean);
    }
}
