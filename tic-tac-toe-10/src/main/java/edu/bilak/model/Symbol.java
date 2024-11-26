package edu.bilak.model;

/** 
 * @author Yuliana
 * @project tic-tac-toe-10
 * @class Symbol
 * @version 1.0.0
 * @since 26/11/2024 — 11.20
**/
public enum Symbol {
    X('X'), O('O'), BLANK('_');

    private final char value;

    Symbol(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
