package edu.bilak.model;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project tic-tac-toe-10
 * @class Board
 * @since 26/11/2024 — 11.04
 **/
public class Board {
    private final Symbol[][] board;

    public Board() {
        board = new Symbol[3][3];
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Symbol.BLANK;
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println();
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j].getValue() + " | ");
            }
        }
        System.out.println();
    }

    public Symbol[][] getBoardState() {
        return board;
    }

    public void setCell(int row, int col, Symbol symbol) {
        board[row][col] = symbol;
    }

    public boolean isCellEmpty(int row, int col) {
        return board[row][col] == Symbol.BLANK;
    }

    public boolean isValidCell(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && isCellEmpty(row, col);
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == Symbol.BLANK) {
                    return false;
                }
            }
        }
        return true;
    }
}
