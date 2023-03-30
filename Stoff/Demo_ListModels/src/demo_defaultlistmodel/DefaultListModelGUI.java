package demo_defaultlistmodel;

import beans.Animal;
import io.IO_FileAccess;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DefaultListModelGUI {
    private JPanel paMain;
    private JPanel paAction;
    private JButton btInsert;
    private JButton btRemove;
    private JButton btLoadFromFile;
    private JButton btSaveToFile;
    private JList<Animal> liData;

    private DefaultListModel<Animal> dlm = new DefaultListModel<>();
    private final String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "res";

    public DefaultListModelGUI() {
        dlm.addElement(new Animal("Emil", 11, "dog"));
        dlm.addElement(new Animal("Maxi", 9, "cat"));
        dlm.addElement(new Animal("Peter", 3, "cat"));
        List<Animal> animals = Arrays.asList(new Animal("Lilly", 1,"cat"),
                                             new Animal("Puppi", 3,"cat"),
                                             new Animal("Nemo", 2,"fish"));
        dlm.addAll(animals);
        // assign DefaultListModel to JList
        liData.setModel(dlm);

        btInsert.addActionListener(this::insert);
        btRemove.addActionListener(this::remove);
        btLoadFromFile.addActionListener(this::loadFromFile);
        btSaveToFile.addActionListener(this::saveToFile);
    }

    public void insert(ActionEvent e) {
        String name = JOptionPane.showInputDialog(new JLabel(), "name of your animal: ");
        int age = Integer.parseInt(JOptionPane.showInputDialog(new JLabel(), "age of your animal: "));
        String species = JOptionPane.showInputDialog(new JLabel(),"species of your animal: ");
        Animal newAnimal = new Animal(name, age, species);
        if(!dlm.contains(newAnimal)) {
            dlm.addElement(newAnimal);
        } else {
            JOptionPane.showMessageDialog(new JLabel(), "This animal already exist!", "Something went wrong", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void remove(ActionEvent e) {
        // index of first selected element
        /* int index = liData.getSelectedIndex();
        if(index != -1) {
            liData.remove(index);
            dlm.remove(index);
        } else {
            JOptionPane.showMessageDialog(new JLabel(), "No animal selected!", "Something went wrong", JOptionPane.INFORMATION_MESSAGE);
        } */

        // indices of all selected elements
        int[] indices = liData.getSelectedIndices();
        System.out.println(Arrays.toString(indices));

        // all selected elements
        List<Animal> selAnimals = liData.getSelectedValuesList();
        System.out.println(selAnimals);

        // remove all seletected elements
        if(indices.length == 0) {
            JOptionPane.showMessageDialog(new JLabel(), "Nothing is selected!", "Something went wrong", JOptionPane.INFORMATION_MESSAGE);
        }

        for(int i = indices.length - 1; i >= 0; i--) {
            dlm.remove(indices[i]);
        }
    }

    public void loadFromFile(ActionEvent e) {
        JFileChooser chooser = new JFileChooser(path);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("text files", "csv", "txt");
        chooser.setFileFilter(filter);

        if(chooser.showOpenDialog(new JLabel()) == JFileChooser.APPROVE_OPTION) {
            String filepath = chooser.getSelectedFile().getAbsolutePath();

            try {
                List<Animal> animals = IO_FileAccess.loadData(filepath);
                Collections.sort(animals);
                dlm.clear();
                dlm.addAll(animals);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(new JLabel(), "Error while loading file!", "Something went wrong", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void saveToFile(ActionEvent e) {
        JFileChooser chooser = new JFileChooser(path);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("text files", "csv", "txt");
        chooser.setFileFilter(filter);

        if(chooser.showSaveDialog(new JLabel()) == JFileChooser.APPROVE_OPTION) {
            String filepath = chooser.getSelectedFile().getAbsolutePath();

            List<Animal> animals = new ArrayList<>();
            for (int i = 0; i < dlm.size(); i++) {
                animals.add(dlm.getElementAt(i));
            }

            try {
                IO_FileAccess.saveData(animals, filepath);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(new JLabel(), "Error while saving file!", "Something went wrong", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("DefaultListModelGUI");
        frame.setContentPane(new DefaultListModelGUI().paMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
