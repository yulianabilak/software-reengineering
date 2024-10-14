package edu.bilak.cpu;

import edu.bilak.common.Word;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project thesaurus-234
 * @class TextAnalyzer
 * @since 02/10/2024 — 11.22
 **/
public class TextAnalyzer {
    private static final Pattern NON_WORD_REGEX = Pattern.compile("\\W+");

    private TextAnalyzer() {}

    public static List<Word> getMostFrequentWords(Stream<String> lines, int count) {
        if (lines == null || count <= 0) {
            return Collections.emptyList();
        }

        Map<String, Long> wordFrequencies = lines
                .parallel()
                .filter(Objects::nonNull)
                .flatMap(NON_WORD_REGEX::splitAsStream)
                .filter(word -> word != null && !word.isEmpty())
                .map(String::toLowerCase)
                .collect(Collectors.groupingByConcurrent(Function.identity(), Collectors.counting()));

        return wordFrequencies.entrySet()
                .stream()
                .map(entry -> new Word(entry.getKey(), Math.toIntExact(entry.getValue())))
                .sorted(Comparator.comparingInt(Word::getFrequency).reversed())
                .limit(count)
                .collect(Collectors.toList());
    }
}
