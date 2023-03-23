package array_tester;

public class Array_Tester {
    public static void main(String[] args) {

        // declaration of an array with 10 integer numbers
        // in C:
        // int values[10];
        // in Java:
        int size = 10;
        int[] values /* values is a vairable referencing an int-array*/ = new int[size]; // here the array will be created

        // init array
        for(int i = 0; i < values.length; i++) {
            values[i] = (i+1) * 10;
        }

        // print array
        for(int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();

        // print array using a foreach loop
        for(int value : values) {
            System.out.print(value + " ");
        }
        System.out.println();

    }
}
