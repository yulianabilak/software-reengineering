package edu.bilak.logic;

import edu.bilak.player.Player;
import edu.bilak.model.Board;
import edu.bilak.model.Move;
import edu.bilak.model.Symbol;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project tic-tac-toe-10
 * @class Game
 * @since 26/11/2024 — 11.08
 **/
public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;

    public Game(Player player1, Player player2) {
        this.board = new Board();
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        Player currentPlayer = player1;
        System.out.println("Tic-Tac-Toe");
        board.printBoard();

        while (true) {
            System.out.println("Turn: " + currentPlayer.getSymbol().getValue());
            Move move = currentPlayer.getMove(board, currentPlayer.getSymbol());
            board.setCell(move.getRow(), move.getCol(), currentPlayer.getSymbol());
            board.printBoard();

            if (isGameOver(move.getRow(), move.getCol(), currentPlayer.getSymbol())) {
                System.out.println("Game over! " + currentPlayer.getSymbol().getValue() + " wins!");
                break;
            }

            if (board.isFull()) {
                System.out.println("Game over! It's a draw!");
                break;
            }

            // Switch players
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }

    private boolean isGameOver(int row, int col, Symbol symbol) {
        Symbol[][] currentBoard = board.getBoardState();

        // Check row
        if (currentBoard[row][0] == symbol && currentBoard[row][1] == symbol && currentBoard[row][2] == symbol) {
            return true;
        }

        // Check column
        if (currentBoard[0][col] == symbol && currentBoard[1][col] == symbol && currentBoard[2][col] == symbol) {
            return true;
        }

        // Check main diagonal
        if (currentBoard[0][0] == symbol && currentBoard[1][1] == symbol && currentBoard[2][2] == symbol) {
            return true;
        }

        // Check secondary diagonal
        return currentBoard[0][2] == symbol && currentBoard[1][1] == symbol && currentBoard[2][0] == symbol;
    }
}
