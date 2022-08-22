package Pieces;

import Squares.Location;
import Squares.Square;
import enums.PiecesType;
import game.Board;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece{
    private final Piece bishop;
    private final Piece rook;
    public King(boolean isWhite) {
        super(isWhite);
        type= PiecesType.KING;
        bishop=new Bishop(isWhite);
        rook=new Rook(isWhite);
    }

    @Override
    public List<Location> getValidMoves(Board board, Square square) {
        return null;
    }

    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> validMoves = new ArrayList<>();
        validMoves.addAll(rook.getValidMoves(board));

    }
}
