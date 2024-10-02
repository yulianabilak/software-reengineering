package edu.bilak.memory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project thesaurus-234
 * @class Main
 * @since 02/10/2024 — 09.55
 **/
public class Main {
    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();

        int topWordsCount = 30;
        Path filePath = Paths.get("src/main/java/edu/bilak/harry.txt");

        Map<String, Integer> wordFrequencies = new HashMap<>();

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                TextAnalyzer.processLine(line, wordFrequencies);
            }
        }

        List<Word> mostFrequentWords = TextAnalyzer.getMostFrequentWords(wordFrequencies, topWordsCount);

        if (mostFrequentWords.isEmpty()) {
            System.out.println("No words found in the file.");
        } else {
            System.out.println(topWordsCount + " most frequent words:\n");
            for (Word word : mostFrequentWords) {
                System.out.println(word);
            }
        }

        long endTime = System.nanoTime();
        long elapsedTimeInMs = (endTime - startTime) / 1_000_000;
        System.out.println("\nElapsed time: " + elapsedTimeInMs + " ms.");
    }
}
