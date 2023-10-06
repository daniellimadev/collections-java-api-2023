package main.java.exercises.map.basicoperations;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {

    private Map<String, String> dictionary;

    public Dictionary() {
        this.dictionary = new HashMap<>();
    }

    public void addWord(String word, String definition) {
        dictionary.put(word, definition);
    }

    public void removeWord(String word) {
        if (!dictionary.isEmpty()) {
            dictionary.remove(word);
        } else {
            System.out.println("The dictionary is empty.");
        }
    }

    public String searchByWord(String word) {
        String definition = dictionary.get(word);
        if (definition != null) {
            return definition;
        }
        return "Language not found in the dictionary.";
    }

    public void showWords() {
        if (!dictionary.isEmpty()) {
            System.out.println(dictionary);
        } else {
            System.out.println("The dictionary is empty.");
        }
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        // Add words (programming languages)
        dictionary.addWord("java", "Linguagem de programação orientada a objetos.");
        dictionary.addWord("typescript", "Superset da linguagem JavaScript que adiciona tipagem estática.");
        dictionary.addWord("kotlin", "Linguagem moderna de programação para a JVM.");

        // Show all words
        dictionary.showWords();

        // Search words
        String definicaoJava = dictionary.searchByWord("java");
        System.out.println("Definição da linguagem 'java': " + definicaoJava);

        String definicaoCSharp = dictionary.searchByWord("csharp");
        System.out.println(definicaoCSharp);

        // Remove a word
        dictionary.removeWord("typescript");
        dictionary.showWords();
    }
}
