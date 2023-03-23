package object_array.beans;

public class Animal {
    private String name;
    private String species;
    private int age;
    private double price;

    public Animal(String name, String species, int age, double price) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.price = price;
    }

    public Animal(String name, String species, double price) {
        this.name = name;
        this.species = species;
        this.age = 1;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("My %s is a %s, aged %d. - %.2f", name, species, age, price);
    }
}
