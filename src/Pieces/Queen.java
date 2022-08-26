package Pieces;

import Squares.Location;
import Squares.Square;
import enums.PiecesType;
import game.Board;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece{
    private final Piece bishop;
    private final Piece rook;
    public Queen(boolean isWhite) {
        super(isWhite);
        type= PiecesType.QUEEN;
        bishop = new Bishop(isWhite);
        rook = new Rook(isWhite);
    }

    @Override
    public List<Location> getValidMoves(Board board, Square square) {
        return null;
    }

    @Override
    public List<Location> getValidMoves(Board board) {

        List<Location> validMoves = new ArrayList<>();
        validMoves.addAll(rook.getValidMoves(board, this.getCurrentSquare()));
        validMoves.addAll(bishop.getValidMoves(board, this.getCurrentSquare()));

        for (int i=1;i<validMoves.size();i++){
            if (validMoves.get(i).getFile() == validMoves.get(i-1).getFile()||validMoves.get(i).getFile().equals(this.getCurrentSquare().getLocation().getFile())){
                validMoves.remove(i);
            }
        }
        return validMoves;
    }
}
