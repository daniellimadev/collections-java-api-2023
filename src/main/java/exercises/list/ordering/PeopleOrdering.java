package main.java.exercises.list.ordering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PeopleOrdering {
    // attributes
    private List<Person> personList;

    public PeopleOrdering() {
        this.personList = new ArrayList<>();
    }

    public void addPerson(String name,int age, double height) {
        personList.add(new Person(name,age,height));
    }

    public List<Person> sortByAge() {
        List<Person> peopleByAge = new ArrayList<>(personList);
        if (!personList.isEmpty()) {
            Collections.sort(peopleByAge);
            return peopleByAge;
        }else {
            throw new RuntimeException("The list is empty!!");
        }
    }

    public List<Person> sortByHeight(){
        List<Person> peopleByHeight = new ArrayList<>(personList);
        if (!personList.isEmpty()) {
            Collections.sort(peopleByHeight);
            return peopleByHeight;
        } else {
            throw new RuntimeException("The list is empty!!");
        }
    }

    public static void main(String[] args) {
        // Creating an instance of the PeopleOrdering class
        PeopleOrdering peopleOrdering = new PeopleOrdering();

        // Adding people to the list
        peopleOrdering.addPerson("Alice", 20, 1.56);
        peopleOrdering.addPerson("Bob", 30, 1.80);
        peopleOrdering.addPerson("Charlie", 25, 1.70);
        peopleOrdering.addPerson("David", 17, 1.56);

        // Displaying the list of added people
        System.out.println(peopleOrdering.personList);

        // Sorting and displaying by age
        System.out.println(peopleOrdering.sortByAge());

        // Sorting and displaying by heightOrdering and displaying by height
        System.out.println(peopleOrdering.sortByHeight());

    }
}
