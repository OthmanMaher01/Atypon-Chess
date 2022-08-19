package Pieces;

import Squares.Location;
import Squares.Square;
import game.Board;

import java.util.List;

public interface Movable {
    List<Location> getValidMoves(Board board);
    List<Location> getValidMoves(Board board, Square square);
    void makeMove(Square square);
}
