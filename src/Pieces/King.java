package Pieces;

import Squares.Location;
import Squares.Square;
import enums.PiecesType;
import game.Board;

import java.util.List;

public class King extends Piece{
    public King(boolean isWhite) {
        super(isWhite);
        type= PiecesType.KING;
    }

    @Override
    public List<Location> getValidMoves(Board board) {
        return null;
    }
}
