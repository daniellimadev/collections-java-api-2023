package main.java.exercises.set.basicoperetions;

import java.util.HashSet;
import java.util.Set;

public class SetUniqueWords {
    // attribute
    private Set<String> uniqueWordsSet;

    public SetUniqueWords() {
        this.uniqueWordsSet = new HashSet<>();
    }

    public void addWord(String word) {
        uniqueWordsSet.add(word);
    }

    public void removeWord(String word) {
        if (!uniqueWordsSet.isEmpty()) {
            if (uniqueWordsSet.contains(word)) {
                uniqueWordsSet.remove(word);
            } else {
                System.out.println("Word not found in set!");
            }
        } else {
            System.out.println("The set is empty!");
        }
    }

    public boolean checkWord(String word) {
        return uniqueWordsSet.contains(word);
    }

    public void displayUniqueWords() {
        if(!uniqueWordsSet.isEmpty()) {
            System.out.println(uniqueWordsSet);
        } else {
            System.out.println("The set is empty!");
        }
    }

    public static void main(String[] args) {
        // Creating an instance of the SetUniqueWords class
        SetUniqueWords setUniqueWords = new SetUniqueWords();

        // Adding unique languages to the pool
        setUniqueWords.addWord("Java");
        setUniqueWords.addWord("Python");
        setUniqueWords.addWord("JavaScript");
        setUniqueWords.addWord("Python");
        setUniqueWords.addWord("C++");
        setUniqueWords.addWord("Ruby");

        // Displaying the unique languages ​​in the set
        setUniqueWords.displayUniqueWords();

        // Removing a language from the set
        setUniqueWords.removeWord("Python");
        setUniqueWords.displayUniqueWords();

        // Removing non-existent language
        setUniqueWords.removeWord("Swift");

        // Checking if a language is in the set
        System.out.println("Is the 'Java' language in the set? " + setUniqueWords.checkWord("Java"));
        System.out.println("Is the 'Python' language in the set? " + setUniqueWords.checkWord("Python"));

        // Displaying the unique languages updated in the suite
        setUniqueWords.displayUniqueWords();
    }
}
