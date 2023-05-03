package beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Student implements Comparable<Student> {
    private String firstname;
    private String lastName;
    private LocalDate dateOfBirth;
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public Student(String firstname, String lastName, LocalDate dateOfBirth) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public static DateTimeFormatter getDtf() {
        return dtf;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(firstname, student.firstname) && Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastName);
    }

    @Override
    public String toString() {
        return String.format("%s, %s - %s", firstname, lastName, dtf.format(dateOfBirth));
    }

    @Override
    public int compareTo(Student o) {
        return firstname.compareTo(o.getFirstname());
    }
}
