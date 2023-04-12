package io;

import beans.Book;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FileAccess {
    public static void save(String filepath, List<Book> books) throws IOException {
        FileWriter fw = new FileWriter(filepath);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("title,author,isbn,publicationYear");
        bw.newLine();

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            bw.write(book.toStringForFile());
            bw.newLine();
        }

        bw.close();
    }

    public static List<Book> load(String filepath) throws IOException {
        List<Book> books = new ArrayList<>();

        FileReader fr = new FileReader(filepath);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();

        while ((line = br.readLine()) != null) {
            String[] tokens = line.split(",");
            Book book = new Book(tokens[0], tokens[1], new BigInteger(tokens[2]), Integer.parseInt(tokens[3]));
            books.add(book);
        }

        br.close();
        return books;
    }
}
