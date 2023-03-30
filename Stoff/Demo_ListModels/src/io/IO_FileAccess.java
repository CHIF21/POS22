package io;

import beans.Animal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IO_FileAccess {

    public static void saveData(List<Animal> animals, String filepath) throws IOException {
        FileWriter fw = new FileWriter(filepath);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("//name,spechies,age");
        bw.newLine();
        for(int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            bw.write(animal.getName() + "," + animal.getSpecies() + "," + animal.getAge());
            bw.newLine();
        }
        bw.close();
    }

    public static List<Animal> loadData(String filepath) throws IOException {
        List<Animal> animals = new ArrayList<>();

        FileReader fr = new FileReader(filepath);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while((line = br.readLine()) != null) {
            String[] tokens = line.split(",");
            Animal animal = new Animal(tokens[0], Integer.parseInt(tokens[2]), tokens[1]);
            animals.add(animal);
        }
        br.close();
        return animals;
    }
}
