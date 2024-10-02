package edu.bilak;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project thesaurus-234
 * @class Main
 * @since 01/10/2024 — 11.44
 **/
public class Main {
    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();

        int topWordsCount = 30;
        Path filePath = Paths.get("src/main/java/edu/bilak/harry.txt");

        String text = new String(Files.readAllBytes(filePath));
        String[] mostFrequentWords = TextAnalyzer.getMostFrequentWords(text, topWordsCount);

        if (mostFrequentWords.length == 0) {
            System.out.println("No words found in the file.");
        } else {
            System.out.println(topWordsCount + " most frequent words:\n");
            for (String mostFrequentWord : mostFrequentWords) {
                System.out.println(mostFrequentWord);
            }
        }

        long endTime = System.nanoTime();
        long elapsedTimeInMs = (endTime - startTime) / 1_000_000;
        System.out.println("\nElapsed time: " + elapsedTimeInMs + " ms.");
    }
}
