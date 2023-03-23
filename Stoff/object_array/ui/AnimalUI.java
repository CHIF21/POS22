package object_array.ui;

import object_array.beans.Animal;

import java.util.Scanner;

public class AnimalUI {
    private Animal[] animals;

    public AnimalUI(int size) {
        animals = new Animal[size];
    }

    public void buyAnimals() {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < animals.length; i++) {
            System.out.format("Animal %d", i+1);
            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Species: ");
            String species = sc.next();

            System.out.print("Age: ");
            int age = sc.nextInt();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            if(age != -1) {
                animals[i] = new Animal(name, species, age, price);
            } else {
                animals[i] = new Animal(name, species, price);
            }
        }
    }

    @Override
    public String toString() {
        String txt = "";
        for (Animal animal : animals) {
            txt += animal.toString();
        }
        return txt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many animals do you want to buy: ");
        int number = sc.nextInt();

        AnimalUI ui = new AnimalUI(number);
        ui.buyAnimals();

        System.out.println(ui);
    }
}
