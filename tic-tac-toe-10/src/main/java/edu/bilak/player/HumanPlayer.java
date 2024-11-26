package edu.bilak.player;

import edu.bilak.model.Board;
import edu.bilak.model.Move;
import edu.bilak.model.Symbol;

import java.util.Scanner;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project tic-tac-toe-10
 * @class HumanPlayer
 * @since 26/11/2024 — 11.38
 **/
public class HumanPlayer implements Player {
    private final Symbol symbol;
    private final Scanner scanner;

    public HumanPlayer(Symbol symbol) {
        this.symbol = symbol;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Move getMove(Board board, Symbol symbol) {
        while (true) {
            System.out.println("Move " + symbol.getValue() + ", insert row and column (1-3):");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (board.isValidCell(row, col)) {
                return new Move(row, col);
            } else {
                System.out.println("Invalid move! Cell is either occupied or out of bounds. Try again.");
            }
        }
    }

    @Override
    public Symbol getSymbol() {
        return symbol;
    }
}
