package main.java.exercises.map.search;

import java.util.HashMap;
import java.util.Map;

public class WordCount {
    // attribute
    private Map<String, Integer> words;

    public WordCount() {
        this.words = new HashMap<>();
    }

    public void addWords(String language, Integer count) {
        words.put(language, count);
    }

    public void removeWord(String word) {
        if (!words.isEmpty()) {
            words.remove(word);
        } else {
            System.out.println("The Map is empty.");
        }
    }

    public int displayWordCount() {
        int Totalcount = 0;
        for (int count : words.values()) {
            Totalcount += count;
        }
        return Totalcount;
    }

    public String findWordsMostFrequent() {
        String MostFrequentLanguage = null;
        int biggestCount = 0;
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            if (entry.getValue() > biggestCount) {
                biggestCount = entry.getValue();
                MostFrequentLanguage = entry.getKey();
            }
        }
        return MostFrequentLanguage;
    }

    public static void main(String[] args) {
        WordCount wordCount = new WordCount();

        // Add language and their counts
        wordCount.addWords("Java", 2);
        wordCount.addWords("Python", 8);
        wordCount.addWords("JavaScript", 1);
        wordCount.addWords("C#", 6);

        // Displays total language count
        System.out.println("Existem " + wordCount.displayWordCount() + " palavras.");

        // Finds and displays the most frequent language
        String linguagemMaisFrequente = wordCount.findWordsMostFrequent();
        System.out.println("A linguagem mais frequente é: " + linguagemMaisFrequente);

        // remove the word
        wordCount.removeWord("C#");

    }
}
