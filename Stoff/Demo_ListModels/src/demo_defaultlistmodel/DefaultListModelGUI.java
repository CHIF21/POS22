package demo_defaultlistmodel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

    }

    public void saveToFile(ActionEvent e) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "res";
        JFileChooser chooser = new JFileChooser(path);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("text files", "csv", "txt");
        chooser.setFileFilter(filter);
        if(chooser.showSaveDialog(new JLabel()) == JFileChooser.APPROVE_OPTION) {
            File file = new File(String.valueOf(chooser.getSelectedFile()));
            if(chooser.getName(file).contains(filter.getExtensions()[0]) || chooser.getName(file).contains(filter.getExtensions()[1])) {
                try {
                    if (file.createNewFile()) {
                        JOptionPane.showMessageDialog(new JLabel(), "File was successful created!", "Successful", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(new JLabel(), "File already exist!", "Something went wrong", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                JOptionPane.showMessageDialog(new JLabel(), "Please use one of the " + Arrays.toString(filter.getExtensions()) + " extensions!", "Something went wrong", JOptionPane.ERROR_MESSAGE);
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
