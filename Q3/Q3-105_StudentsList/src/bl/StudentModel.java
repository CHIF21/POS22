package bl;

import beans.Student;

import javax.swing.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentModel extends AbstractListModel<Student> {

    private List<Student> allStudents = null;

    public StudentModel() {
        allStudents = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return allStudents.size();
    }

    @Override
    public Student getElementAt(int index) {
        return allStudents.get(index);
    }

    public void insertStudent(Student student) {
        if(!isEqual(student)) {
            allStudents.add(student);
            this.fireContentsChanged(this, 0, allStudents.size()-1);
            sortStudents();
        }
    }

    public void removeStudent(List<Student> students) {
        allStudents.removeAll(students);
        this.fireContentsChanged(this, 0, allStudents.size()-1);
    }

    public void updateStudent(Student oldStudent, Student newStudent) {

        oldStudent.setFirstname(newStudent.getFirstname());
        oldStudent.setLastName(newStudent.getLastName());
        oldStudent.setDateOfBirth(newStudent.getDateOfBirth());

        this.fireContentsChanged(this, 0, allStudents.size()-1);
        sortStudents();
    }

    public void sortStudents() {
        Collections.sort(allStudents);
        this.fireContentsChanged(this, 0, allStudents.size()-1);
    }

    public boolean isEqual(Student student) {
        return allStudents.contains(student);
    }
}
