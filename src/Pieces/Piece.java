package Pieces;

import Squares.Location;
import Squares.Square;
import enums.PiecesType;
import game.Board;

import java.util.List;

public abstract class Piece {

    public PiecesType type;
    private Square currentSquare;
    private final boolean isWhite;
  //  private boolean isAlive;

    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
       // this.isAlive=true;
    }


//    public boolean isAlive() {
//        return isAlive;
//    }

//    public void setAlive(boolean alive) {
//        isAlive = alive;
//    }
    public PiecesType getType() {
        return type;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public Square getCurrentSquare() {
        return currentSquare;
    }

    public void setCurrentSquare(Square currentSquare) {
        this.currentSquare = currentSquare;
    }

    public abstract List<Location> getValidMoves(Board board);
    public abstract List<Location> getValidMoves(Board board,Square square);
    public void movePiece(Square square,Board board){
        List<Location> validMoves = getValidMoves(board);
        System.out.println("valid moves :"+validMoves);
        if (!validMoves.contains(square.getLocation())){
            throw new IllegalStateException();
        }
        this.currentSquare.reset();
        square.setCurrentPiece(this);
        square.setOccupied(true);
        this.setCurrentSquare(square);

    }
}
