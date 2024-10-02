package edu.bilak.memory;

import java.util.Objects;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project thesaurus-234
 * @class Word
 * @since 02/10/2024 — 10.30
 **/
public class Word {
    private final String word;
    private final int frequency;

    public Word(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    public String getWord() {
        return word;
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return Objects.equals(word, word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(word);
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", frequency=" + frequency +
                '}';
    }
}
