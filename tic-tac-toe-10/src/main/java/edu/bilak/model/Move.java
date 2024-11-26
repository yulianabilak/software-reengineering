package edu.bilak.model;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project tic-tac-toe-10
 * @class Move
 * @since 26/11/2024 — 11.49
 **/
public class Move {
    private final int row;
    private final int col;

    public Move(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
