package list_tester;

import java.util.*;

public class ListExercises {

    public void computeFibonacciNumbers() {
        // create a list with given numbers, but this cannot be changed anymore!
        // List<Integer> numbers = Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21, 34, 55);

        List<Integer> fibo = new ArrayList<>();

        // fill the list with the first ten fibonacci numbers
        fibo.add(1);
        fibo.add(1);
        for(int i = 2; i < 10; i++) {
            fibo.add(fibo.get(i-2) + fibo.get(i-1));
        }
        System.out.println(fibo);

        //fill the list with non-fibonnacci numbers up to the last fibonacci number (here: 55)
        int last = fibo.get(fibo.size()-1);
        for(int i = 1; i < last; i++) {
            if(!fibo.contains(i)) {
                fibo.add(i);
            }
        }

        System.out.println(fibo);

        // sort list - variant 1:
        /* Collections.sort(fibo); // -> natural order
        System.out.println(fibo); */

        // sort list - variant 2:
        /* fibo.sort(null);
        System.out.println(fibo); */

        // sort list - variant 3:
        fibo.sort(Comparator.naturalOrder());
        System.out.println(fibo);
    }

    public static void main(String[] args) {
        ListExercises listE = new ListExercises();
        listE.computeFibonacciNumbers();
    }
}
