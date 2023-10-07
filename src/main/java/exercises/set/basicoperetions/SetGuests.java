package main.java.exercises.set.basicoperetions;

import java.util.HashSet;
import java.util.Set;

public class SetGuests {
    // attribute
    private Set<Guest> guestSet;

    public SetGuests() {
        this.guestSet = new HashSet<>();
    }

    public void addGuest(String name, int codeInvitation) {
        guestSet.add(new Guest(name, codeInvitation));
    }

    public void removeInvitedByCodigoConvite(int codeInvitation) {
        Guest guestToRemove = null;
        if (!guestSet.isEmpty()) {
            for (Guest c : guestSet) {
                if (c.getCodeInvitation() == codeInvitation) {
                    guestToRemove = c;
                    break;
                }
            }
            guestSet.remove(guestToRemove);
        } else {
            throw new RuntimeException("The set is empty!");
        }
    }

    public int countGuests() {
        return guestSet.size();
    }

    public void showGuests() {
        if (!guestSet.isEmpty()) {
            System.out.println(guestSet);
        } else {
            System.out.println("The set is empty!");
        }
    }

    public static void main(String[] args) {
        // Creating an instance of the ConjuntoInvidados class
        SetGuests setGuests = new SetGuests();

        // Displaying the number of guests in the set (must be zero)
        System.out.println("They exist " + setGuests.countGuests() + " guest(s) within the Guest Set");

        // Adding guests to the pool
        setGuests.addGuest("Alice", 1234);
        setGuests.addGuest("Bob", 1235);
        setGuests.addGuest("Charlie", 1235);
        setGuests.addGuest("David", 1236);

        // Displaying the guests in the set
        System.out.println("Guests in the set:");
        setGuests.showGuests();

        // Displaying the updated number of guests in the suite
        System.out.println("They exist " + setGuests.countGuests() + " guest(s) within the Guest Set");

        // Removing a guest from the pool by invitation code
        setGuests.removeInvitedByCodigoConvite(1236);
        System.out.println("They exist " + setGuests.countGuests() + " guest(s) within the Guest Set after removal");

        // Displaying the updated guests in the pool
        System.out.println("Guests in the set after removal:");
        setGuests.showGuests();
    }
}
