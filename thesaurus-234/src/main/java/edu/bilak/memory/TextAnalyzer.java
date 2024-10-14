package edu.bilak.memory;

import edu.bilak.common.Word;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project thesaurus-234
 * @class TextAnalyzer
 * @since 02/10/2024 — 09.55
 **/
public class TextAnalyzer {

    private TextAnalyzer() {}

    public static void processLine(String line, Map<String, Integer> wordFrequencyMap) {
        StringBuilder wordBuilder = new StringBuilder();

        for (char c : line.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                wordBuilder.append(Character.toLowerCase(c));
            } else {
                // If we encounter a non-alphabetic character and have a word, update the map
                if (!wordBuilder.isEmpty()) {
                    String word = wordBuilder.toString();
                    wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
                    wordBuilder.setLength(0);  // Reset the builder for the next word
                }
            }
        }

        // Handle the last word if the line ends with a word
        if (!wordBuilder.isEmpty()) {
            String word = wordBuilder.toString();
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }
    }

    public static List<Word> getMostFrequentWords(Map<String, Integer> wordFrequencies, int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Count must be a positive integer.");
        }

        List<Word> words = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet()) {
            words.add(new Word(entry.getKey(), entry.getValue()));
        }

        words.sort((w1, w2) -> Integer.compare(w2.getFrequency(), w1.getFrequency()));
        return words.subList(0, Math.min(count, words.size()));
    }
}
