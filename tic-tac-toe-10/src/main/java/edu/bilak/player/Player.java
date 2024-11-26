package edu.bilak.player;

import edu.bilak.model.Board;
import edu.bilak.model.Move;
import edu.bilak.model.Symbol;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project tic-tac-toe-10
 * @class Player
 * @since 26/11/2024 — 11.38
 **/
public interface Player {
    Move getMove(Board board, Symbol symbol);
    Symbol getSymbol();
}
