package edu.bilak;

import edu.bilak.logic.Game;
import edu.bilak.model.Symbol;
import edu.bilak.player.HumanPlayer;
import edu.bilak.player.Player;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project tic-tac-toe-10
 * @class GameRunner
 * @since 26/11/2024 — 11.14
 **/
public class GameRunner {
    public static void main(String[] args) {
        Player player1 = new HumanPlayer(Symbol.X);
        Player player2 = new HumanPlayer(Symbol.O);

        Game game = new Game(player1, player2);
        game.start();
    }
}
