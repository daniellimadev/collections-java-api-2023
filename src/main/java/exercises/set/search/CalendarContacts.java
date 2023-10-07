package main.java.exercises.set.search;

import java.util.HashSet;
import java.util.Set;

public class CalendarContacts {
    // attributes
    private Set<Contact> contactSet;

    public CalendarContacts() {
        this.contactSet = new HashSet<>();
    }

    public void addContact(String name, int number) {
        contactSet.add(new Contact(name, number));
    }

    public void showContacts() {
        if (!contactSet.isEmpty()) {
            System.out.println(contactSet);
        } else {
            System.out.println("The set is empty!");
        }
    }

    public Set<Contact> searchByName(String nome) {
        Set<Contact> contactsByName = new HashSet<>();
        if (!contactSet.isEmpty()) {
            for (Contact c : contactSet) {
                if (c.getName().startsWith(nome)) {
                    contactsByName.add(c);
                }
            }
            return contactsByName;
        } else {
            throw new RuntimeException("The set is empty!");
        }
    }

    public Contact updateContactNumber(String name, int newNumber) {
        Contact contactUpdated = null;
        if (!contactSet.isEmpty()) {
            for (Contact c : contactSet) {
                if (c.getName().equalsIgnoreCase(name)) {
                    c.setNumber(newNumber);
                    contactUpdated = c;
                    break;
                }
            }
            return contactUpdated;
        } else {
            throw new RuntimeException("The set is empty!");
        }
    }

    public static void main(String[] args) {
        // Creating an instance of the AgendaContacts class
        CalendarContacts calendarContacts = new CalendarContacts();

        // Displaying contacts in the pool (must be empty)
        calendarContacts.showContacts();

        // Adding contacts to the calendar
        calendarContacts.addContact("João", 123456789);
        calendarContacts.addContact("Maria", 987654321);
        calendarContacts.addContact("Maria Fernandes", 55555555);
        calendarContacts.addContact("Ana", 88889999);
        calendarContacts.addContact("Fernando", 77778888);
        calendarContacts.addContact("Carolina", 55555555);

        // Displaying contacts in the calendar
        calendarContacts.showContacts();

        // Searching contacts by name
        System.out.println(calendarContacts.searchByName("Maria"));

        // Searching contacts by name
        Contact contactUpdated = calendarContacts.updateContactNumber("Carolina", 44443333);
        System.out.println("Contact updated: " + contactUpdated);

        // Displaying updated contacts in the calendar
        System.out.println("Contacts in the calendar after update:");
        calendarContacts.showContacts();
    }
}
