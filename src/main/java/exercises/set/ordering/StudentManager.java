package main.java.exercises.set.ordering;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class StudentManager {
    // attribute
    private Set<Student> studentSet;

    public StudentManager() {
        this.studentSet = new HashSet<>();
    }

    public void addStudent(String name, Long registration, double average) {
        studentSet.add(new Student(name, registration, average));
    }

    public void removeStudentByRegistration(long registration) {
        Student studentToRemove = null;
        if (!studentSet.isEmpty()) {
            for (Student a : studentSet) {
                if (a.getRegistration() == registration) {
                    studentToRemove = a;
                    break;
                }
            }
            studentSet.remove(studentToRemove);
        } else {
            throw new RuntimeException("The set is empty!");
        }

        if (studentToRemove == null) {
            System.out.println("License plate not found!");
        }
    }

    public void displayStudentsByName() {
        Set<Student> studentsByName = new TreeSet<>(studentSet);
        if (!studentSet.isEmpty()) {
            System.out.println(studentsByName);
        } else {
            System.out.println("The set is empty!");
        }
    }

    public void showStudentsByNota() {
        Set<Student> studentsByNote = new TreeSet<>(new ComparatorNote());
        if (!studentSet.isEmpty()) {
            studentsByNote.addAll(studentSet);
            System.out.println(studentsByNote);
        } else {
            System.out.println("The set is empty!");
        }
    }

    public static void main(String[] args) {
        // Creating an instance of Student Manager
        StudentManager studentManager = new StudentManager();

        // Adding students to the manager
        studentManager.addStudent("João", 123456L, 7.5);
        studentManager.addStudent("Maria", 123457L, 9.0);
        studentManager.addStudent("Carlos", 123458L, 5.0);
        studentManager.addStudent("Ana", 123459L, 6.8);

        // Displaying all students in the manager
        System.out.println("Students in the manager:");
        System.out.println(studentManager.studentSet);

        // Removing a student with invalid registration and another by registration number
        studentManager.removeStudentByRegistration(000L);
        studentManager.removeStudentByRegistration(123457L);
        System.out.println(studentManager.studentSet);

        // Displaying students sorted by name
        studentManager.displayStudentsByName();

        // Displaying students ordered by grade
        studentManager.showStudentsByNota();
    }
}
