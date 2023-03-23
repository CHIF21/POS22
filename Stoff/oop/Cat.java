package oop;

import java.util.Arrays;

// class declaration of class Cat
public class Cat {
    // declaration of instance variables
    //      - they are initialized with the corresponding default value
    //        (int -> 0; float -> 0.0f, double -> 0.0, boolean -> false,
    //         String -> null, ....)
    //      - they belong to ONE (1) object of the class Cat

    private String name;
    private int age;
    private int numberOfLives;

    // default constructor: - has no parameters
    //                      - this constructor will be inserted automatically,
    //                        in there exists no other constructor.
    public Cat() {

    }

    // first constructor
    public Cat(String name, int age, int numberOfLives) {
        this.name = name;
        this.age = age;
        this.numberOfLives = numberOfLives;
    }

    // second constructor
    public Cat(String name) {
        this.name = name;
    }

    // setter-methods are necessary to set the values of instance variables
    public void setName(String name) {
        this.name = name;
    }

    public void setName(String name, String nickname) {
        this.name = name + nickname;
    }
    // getter-methods are necessary to obtain a value of an instance variable
    public String getName() {
        return name;
    }
    public void output() {
        System.out.format("%s (%d) - %d lives\n", name, age, numberOfLives);
    }


    // a class can have maximal one main()-method
    public static void main(String[] args) {
        // create on object of the class Cat ("instantiate an object") with the new-operator. <- Merken!
        Cat kai = new Cat();// -> default constructor will be called
        kai.output();

        Cat bake = new Cat("bake", 4, 6);
        bake.output();

        Cat mile = new Cat("Mile");
        mile.output();

        kai.setName("Kai");
        kai.output();

        bake.setName(mile.getName());
        bake.output();

        mile.setName("Mile: ", "Mii");
        mile.output();

        Cat tom; // tom ... reference variable, holds the storage address of the
                 // Cat object. But to this time, tom has the vaule null
                 // because the object does not exist yet!
        tom = new Cat("Tom", 5, 2);
                 // the class Cat
                 // -> storage will be allacoted for all instance variables
                 // of the new object
                 // Now the variable tom gets a valid storage address as value.
                 // if the garbage collector determines at any later time,
                 // that there exists no reference variable, which references
                 // the address of this object, the storage of the object will be given free

        // array of cat-objects
        Cat[] cats = new Cat[5];
        for (int i=0; i < cats.length; i++) {
            cats[i] = new Cat("name_" + (i+1), (i+1) * 2, (7-i));
        }

        for (Cat cat : cats) {
            cat.output();
        }
    }
}
