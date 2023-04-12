package gui;

import beans.Book;
import io.FileAccess;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class LibraryGUI {
    private JPanel paMain;
    private JList<Book> liLibrary;
    private JButton btInsert;
    private JButton btDelete;
    private JButton btSort;
    private JButton btLoad;
    private JButton btWrite;
    private DefaultListModel<Book> dlm = new DefaultListModel<>();
    private final String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "res";

    public LibraryGUI() {
        btInsert.addActionListener(e -> onInsert());
        btDelete.addActionListener(e -> onDelete());
        btSort.addActionListener(e -> onSort());
        btLoad.addActionListener(e -> onLoad());
        btWrite.addActionListener(e -> onWrite());

        liLibrary.setModel(dlm);
        liLibrary.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }

    private void onInsert() {
        String title = JOptionPane.showInputDialog("Title of the book: ");
        String author = JOptionPane.showInputDialog("Author of the book: ");
        BigInteger isbn = null;
        int year = 0;

        try {
            isbn = new BigInteger(JOptionPane.showInputDialog("ISBN of the book: "));
            year = Integer.parseInt(JOptionPane.showInputDialog("Publication year of the book"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "This was not a number!");
            return;
        } catch (NullPointerException e) {
            return;
        }

        dlm.addElement(new Book(title, author, isbn, year));
    }

    private void onDelete() {
        int[] indices = liLibrary.getSelectedIndices();
        if (indices.length != 0) {
            for (int i = indices.length - 1; i >= 0; i--) {
                dlm.remove(indices[i]);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nothing was selected");
        }
    }

    private void onSort() {
        Enumeration<Book> enumBook = dlm.elements();
        List<Book> books = new ArrayList<>();
        Book book;

        while (enumBook.hasMoreElements()) {
            book = enumBook.nextElement();
            books.add(book);
        }

        Collections.sort(books);
        dlm.clear();
        dlm.addAll(books);
    }

    private void onLoad() {
        JFileChooser chooser = new JFileChooser(path);
        chooser.setFileFilter(new FileNameExtensionFilter("csv file", "csv"));
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            String filepath = chooser.getSelectedFile().getAbsolutePath();
            try {
                List<Book> books = FileAccess.load(filepath);
                Collections.sort(books);
                dlm.clear();
                dlm.addAll(books);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error while loading file");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Some data is not correct");
            }
        }
    }

    private void onWrite() {
        JFileChooser chooser = new JFileChooser(path);
        chooser.setFileFilter(new FileNameExtensionFilter("csv file", "csv"));
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            String filepath = chooser.getSelectedFile().getAbsolutePath();
            List<Book> books = new ArrayList<>();
            Book book;
            Enumeration<Book> bookEnumeration = dlm.elements();

            while (bookEnumeration.hasMoreElements()) {
                book = bookEnumeration.nextElement();
                books.add(book);
            }

            try {
                FileAccess.save(filepath, books);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error while saving file");
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("LibraryGUI");
        frame.setContentPane(new LibraryGUI().paMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
