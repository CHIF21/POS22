package list_tester;

/*
    List:
        * is an interface (this is similar to a class, but it is not allowed to instantiate an object of an interface)
        * Following classes implement the interface List:
            -> ArrayList
            -> LinkList
            -> Vector
        * At the declaration of a list, you should always specify a generic data type
        * The generic data type is enclosed by < and >, for example: <String>, <Integer>, <Person>, ...
            -> A list can obtain only objects, so the generic data type must be a class name.
            -> Primitive data types like int, float, ... are not allowed.
                => int -> Integer | float -> Float | boolean -> Boolean ...
        * The advantage of using a generic data type is that the compiler can test, if for example an element to insert is of the same type
          as the generic data type. (otherwise -> error message)
        * A non-generic List (that means: no generic data type was specified) can obtain objects
          of the class Object. Since every class is automatically dervied of the class Object, the
          list can obtain objects of different classes.
        * After insertion or deletion of an element, the size of the list adjusts dynamically.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTester {

    public static void testNonGenericList() {
        // ArrayList myList = new ArrayList();
        List myList = new ArrayList();
        myList.add(1);
        myList.add(3.5);
        myList.add("Hello");
        System.out.println("non generic list:");
        for(int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
    }

    public static void testArrayAndList() {
        // ---- decleration ----
        // array decleration
        int[] intArray = new int[10];

        // List decleration
        List<Integer> intList = new ArrayList<>(); // <> ... diamond operator

        // ---- Initialization ----
        // array
        for(int i = 0; i < intArray.length; i++) {
            intArray[i] = i + 1;
        }

        // list
        for(int i = 1; i <= 10; i++) {
            intList.add(i); // int -> Integer is called "auto boxing" | "i" will be added at the end of the list
        }

        // ---- Output ----
        // array
        System.out.println("array:");
        // 1. via toString-method();
        System.out.println(Arrays.toString(intArray));

        // 2. for-Loop
        for(int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }

        System.out.println("");
        // 3. for-Each
        for(int value : intArray) {
            System.out.print(value + " ");
        }

        // list
        System.out.println("\nlist:");
        // 1. via toString-Method()
        System.out.println(intList.toString());

        // 2. via for-Loop
        for(int i = 0; i < intList.size(); i++) {
            System.out.print(intList.get(i) + "");
        }

        System.out.println("");
        // 3. via for-Each
        for(int value : intList) {
            System.out.print(value + " ");
        }

        // ---- Insert a new value ----
        System.out.println("");
        intList.add(0, 9999);
        System.out.println(intList);
        intList.add(5, 1234);
        System.out.println(intList);
        // intList.add(15, 1111); // -> IndexOutOfBoundException
        // System.out.println(intList);
        intList.add(1111); // inserts 1111 at the end of the list
        System.out.println(intList);

        // ---- Change values ----
        System.out.println("");
        // array:
        intArray[3] = 2222;
        System.out.println("array: " + Arrays.toString(intArray));

        // list:
        intList.set(3, 2222);
        System.out.println("list: " + intList);

        // ---- delete the value at index 5 ----
        // array:
        for(int i = 5; i < intArray.length - 1; i++) {
            intArray[i] = intArray[i+1];
        }
        intArray[intArray.length - 1] = -1;
        System.out.println("array: " + Arrays.toString(intArray));

        // list:
        intList.remove(5);
        System.out.println("list: " + intList);

        intList.remove(Integer.valueOf(2222));
            // Integer.valueOf is necessary for distinction between
            // index and object, because there are two overloaded
            // methods remove()
        System.out.println("list: " + intList);

        // ---- some further useful methods ----
        System.out.println("");
        // search for an element
        System.out.println("list contains the element 1234: " + intList.contains(1234));

        // get index of an element
        System.out.println("element 9999 is at index " + intList.indexOf(9999));

        // delete all elements of a list
        intList.clear();
        System.out.println(intList);
    }

    public static void main(String[] args) {
        ListTester.testNonGenericList();
        System.out.println("");
        ListTester.testArrayAndList();
    }
}
