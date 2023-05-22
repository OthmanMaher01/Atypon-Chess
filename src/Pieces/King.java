package Pieces;

import Squares.Location;
import Squares.Square;
import enums.PiecesType;
import game.Board;

import java.util.*;
import java.util.stream.Collectors;

public class King extends Piece {
    private final Piece bishop;
    private final Piece rook;
    private boolean isChecked;

    // changes on King by f1
    public King(boolean isWhite) {
        super(isWhite);
        type = PiecesType.KING;
        bishop = new Bishop(isWhite);
        rook = new Rook(isWhite);
        isChecked = false;
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

    public  boolean isInCheck(Board board)
    {
    List<Piece>enemies = this.isWhite()?board.getBlackPieces():board.getWhitePieces();
    for (Piece piece : enemies) {
        List<Location> enemyMoves = piece.getValidMoves(board);
        if (enemyMoves.contains(this.getCurrentSquare().getLocation())) {
            return true;
        }
    }
       return false;
    }
    public boolean isInCheckMate(Board board){
        if (this.isInCheck(board)){
            List<Piece>pieces = this.isWhite()?board.getWhitePieces():board.getBlackPieces();
            Map<Location, Square> squareMap = board.getLocationMap();

            for (Piece piece : pieces) {
                Square fromSquare = piece.getCurrentSquare();
                List<Location>validMoves = piece.getValidMoves(board);
                for (Location move : validMoves){
                    Square pieceMove = squareMap.get(move);
                    piece.move(pieceMove,board);
                    if (this.isInCheck(board) || piece.getType().equals(PiecesType.KING)){
                        piece.move(fromSquare,board);
                       continue;
                    }
                    piece.move(fromSquare,board);
                    return false;

                }
            }

            return true;
            }

        return false;
    }

}
