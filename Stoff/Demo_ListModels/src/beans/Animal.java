package beans;

import java.util.Objects;

public class Animal implements Comparable<Animal>{
    private String name;
    private int age;
    private String species;

    public Animal(String name, int age, String species) {
        this.name = name;
        this.age = age;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSpecies() {
        return species;
    }

    @Override
    public String toString() {
        return String.format("%s %s - %d", species, name, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age && Objects.equals(name, animal.name) && Objects.equals(species, animal.species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, species);
    }

    @Override
    public int compareTo(Animal o) {
        // return values:
        // < 0 --> this-object < o-object
        // = 0 --> this-object "is the same" as o-object
        // > 0 --> this-object > o-object

        // sort by name:
        //return name.compareTo(o.getName());

        // sort by species:
        // return species.compareTo(o.getSpecies());

        // sort by age:
        // return Integer.valueOf(age).compareTo(o.getAge());
        // return age - o.getAge();

        // sort by species / name:
        /* if(species.equals(o.getSpecies())) {
            return name.compareTo(o.getName());
        }
        return species.compareTo(o.getSpecies()); */

        // sort by name descending
        // 1. version:
        // return name.compareTo(o.getName()) * (-1);

        // 2. version:
        return o.getName().compareTo(name);
    }
}
