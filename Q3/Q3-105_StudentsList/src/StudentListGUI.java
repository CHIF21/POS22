import beans.Student;
import bl.StudentModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class StudentListGUI {
    private JTextField tfLastName;
    private JTextField tfDate;
    private JTextField tfFirstName;
    private JButton btInsert;
    private JButton btUpdate;
    private JButton btDelete;
    private JList<Student> liStudentData;
    private JLabel laFirstName;
    private JLabel laLastName;
    private JLabel laDate;
    private JPanel paList;
    private JPanel paMain;
    private JPanel paAction;

    private StudentModel sm = new StudentModel();


    public StudentListGUI() {
        liStudentData.setModel(sm);
        liStudentData.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        btInsert.addActionListener(e -> onInsert());
        btDelete.addActionListener(e -> onRemove());
        btUpdate.addActionListener(e -> onUpdate());
        liStudentData.addListSelectionListener(e -> onDisplay());
    }

    private void onUpdate() {
        if(isBlank()) return;

        if(liStudentData.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(new JLabel(), "Bitte wähle einen Wert aus der Liste aus!", "Something went wrong", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Student oldStudent = liStudentData.getSelectedValue();

        try {
            Student newStudent = new Student(tfFirstName.getText(), tfLastName.getText(), LocalDate.parse(tfDate.getText(), Student.getDtf()));
            sm.updateStudent(oldStudent, newStudent);
        } catch (DateTimeException e) {
            JOptionPane.showMessageDialog(new JLabel(), "The date format is: 01.01.2000", "Something went wrong", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onRemove() {
        List<Student> students = liStudentData.getSelectedValuesList();
        sm.removeStudent(students);
    }

    public void onInsert() {
        if(isBlank()) return;

        try {
            sm.insertStudent(new Student(tfFirstName.getText(), tfLastName.getText(), LocalDate.parse(tfDate.getText(), Student.getDtf())));
        } catch (DateTimeException e) {
            JOptionPane.showMessageDialog(new JLabel(), "The date format is: 01.01.2000", "Something went wrong", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void onDisplay() {
        Student student = liStudentData.getSelectedValue();
        tfFirstName.setText(student.getFirstname());
        tfLastName.setText(student.getLastName());
        tfDate.setText(Student.getDtf().format(student.getDateOfBirth()));
    }

    public boolean isBlank() {
        if(tfFirstName.getText().isBlank()) {
            JOptionPane.showMessageDialog(new JLabel(), "Please type your firstname!", "Something went wrong", JOptionPane.ERROR_MESSAGE);
            return true;
        } else if(tfLastName.getText().isBlank()) {
            JOptionPane.showMessageDialog(new JLabel(), "Please type your lastname!", "Something went wrong", JOptionPane.ERROR_MESSAGE);
            return true;
        } else if(tfDate.getText().isBlank()) {
            JOptionPane.showMessageDialog(new JLabel(), "Please type your birthday!", "Something went wrong", JOptionPane.ERROR_MESSAGE);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("StudentListGUI");
        frame.setContentPane(new StudentListGUI().paMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
