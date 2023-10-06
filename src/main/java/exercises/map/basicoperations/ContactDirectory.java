package main.java.exercises.map.basicoperations;

import java.util.HashMap;
import java.util.Map;

public class ContactDirectory {
    //attribute
    private Map<String, Integer> contactDirectoryMap;

    public ContactDirectory() {
        this.contactDirectoryMap = new HashMap<>();
    }

    public void addContact(String name, Integer phone) {
        contactDirectoryMap.put(name,phone);
    }
    public void removeContact(String name) {
        if (!contactDirectoryMap.isEmpty()) {
            contactDirectoryMap.remove(name);
        } else {
            System.out.println("The contact book is empty!!");
        }
    }
    public void showContacts() {
        if (!contactDirectoryMap.isEmpty()) {
            System.out.println(contactDirectoryMap);
        } else {
            System.out.println("The contact book is empty!!");
        }
    }

    public Integer searchByName(String name) {
        Integer numberByName = null;
        if (!contactDirectoryMap.isEmpty()) {
            numberByName = contactDirectoryMap.get(name);
            if (numberByName == null) {
                System.out.println("Contact not found in the calendar.");
            }
        } else {
            System.out.println("The contact book is empty!!");
        }
        return numberByName;
    }

    public static void main(String[] args) {

        ContactDirectory contactDirectory = new ContactDirectory();

        // Add contacts
        contactDirectory.addContact("Camila", 123456);
        contactDirectory.addContact("João", 5665);
        contactDirectory.addContact("Carlos", 1111111);
        contactDirectory.addContact("Ana", 654987);
        contactDirectory.addContact("Maria", 1111111);
        contactDirectory.addContact("Camila", 44444);

        // Display contact
        contactDirectory.showContacts();

        // Remove a contact
        contactDirectory.removeContact("Maria");
        contactDirectory.showContacts();

        // Search number by name
        String searchName = "Camila";
        Integer serchNumber = contactDirectory.searchByName("Camila");
        System.out.println("Telephone number of " + searchName + ": " + serchNumber);

        String searchNameNonexistent = "Daniel";
        Integer searchNumberNonexistent = contactDirectory.searchByName("Daniel");
        System.out.println("Telephone number of " + searchNameNonexistent + ": " + searchNumberNonexistent);

    }
}
