package Pieces;

import Squares.Location;
import Squares.Square;
import enums.PiecesType;
import game.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class King extends Piece {
    private final Piece bishop;
    private final Piece rook;

    public King(boolean isWhite) {
        super(isWhite);
        type = PiecesType.KING;
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
        Location current = this.getCurrentSquare().getLocation();
        return validMoves.stream().filter(move->{
            if(Math.abs(move.getFile().ordinal()-current.getFile().ordinal())==1 && Math.abs(move.getRank()- current.getRank())==1){
                return true;
            }
            if(Math.abs(move.getFile().ordinal()-current.getFile().ordinal())==0 && Math.abs(move.getRank()- current.getRank())==1){
                return true;
            }
            return false;
        }).collect(Collectors.toList());



    }
}
