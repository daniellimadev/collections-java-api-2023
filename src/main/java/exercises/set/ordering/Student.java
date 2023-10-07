package main.java.exercises.set.ordering;

import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparable<Student> {
    // attributes

    private String name;
    private Long registration;
    private double average;

    public Student(String name, Long registration, double average) {
        this.name = name;
        this.registration = registration;
        this.average = average;
    }

    public String getName() {
        return name;
    }

    public Long getRegistration() {
        return registration;
    }

    public double getAverage() {
        return average;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(getRegistration(), student.getRegistration());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRegistration());
    }

    @Override
    public int compareTo(Student student) {
        return name.compareTo(student.getName());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", registration=" + registration +
                ", average=" + average +
                '}';
    }


}

class ComparatorNote implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s1.getAverage(), s2.getAverage());
    }
}
