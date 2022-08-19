package Pieces;

import Squares.Location;
import Squares.Square;
import enums.PiecesType;
import game.Board;

import java.util.List;

public class Queen extends Piece{
    public Queen(boolean isWhite) {
        super(isWhite);
        type= PiecesType.QUEEN;
    }

    @Override
    public List<Location> getValidMoves(Board board) {
        return null;
    }

    @Override
    public List<Location> getValidMoves(Board board, Square square) {
        return null;
    }

    @Override
    public void makeMove(Square square) {

    }
}
