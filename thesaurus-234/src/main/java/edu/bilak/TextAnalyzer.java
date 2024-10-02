package edu.bilak;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project thesaurus-234
 * @class TextAnalyzer
 * @since 01/10/2024 — 18.51
 **/
public class TextAnalyzer {
    private static final String NON_ALPHABETIC_REGEX = "[^A-Za-z]";
    private static final String SPACE_REGEX = "\\s+";
    private static final String WORD_BOUNDARY_BEFORE = ".*\\b";
    private static final String WORD_BOUNDARY_AFTER = "\\b.*";
    private static final String NON_NUMERIC_REGEX = "[^0-9]";

    private TextAnalyzer() {}

    private static String[] getAllWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return new String[0];
        }
        text = text.replaceAll(NON_ALPHABETIC_REGEX," ").toLowerCase(Locale.ROOT);
        return text.split(SPACE_REGEX);
    }

    private static String[] getUniqueWords(String[] textWords) {
        String uniqueWordsAsString = "";
        String wordRegex;
        Arrays.sort(textWords);

        for (String textWord : textWords) {
            wordRegex = WORD_BOUNDARY_BEFORE + Pattern.quote(textWord) + WORD_BOUNDARY_AFTER;
            if (!uniqueWordsAsString.matches(wordRegex)) {
                uniqueWordsAsString += textWord + " ";
            }
        }

        return uniqueWordsAsString.split(" ");
    }

    public static String[] getMostFrequentWords(String text, int count) {
        String[] textWords = getAllWords(text);
        if (textWords.length == 0) {
            return new String[0];
        }
        String[] uniqueWords = getUniqueWords(textWords);

        for (int i = 0; i < uniqueWords.length ; i++) {
            int wordCount = 0;
            for (String textWord : textWords) {
                if (uniqueWords[i].equals(textWord)) {
                    wordCount++;
                }
            }
            uniqueWords[i] += " " + wordCount;
        }

        Arrays.sort(uniqueWords, Comparator.comparing(str -> {
                    String numericPart = str.replaceAll(NON_NUMERIC_REGEX, "");
                    return numericPart.isEmpty() ? 0 : Integer.parseInt(numericPart);
                    }, Comparator.reverseOrder()));

        return Arrays.copyOfRange(uniqueWords, 0, Math.min(count, uniqueWords.length));
    }
}
