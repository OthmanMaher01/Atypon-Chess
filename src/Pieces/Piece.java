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
    public void movePiece(Square square,Board board) throws Exception {
        List<Location> validMoves = getValidMoves(board);
        if (!validMoves.contains(square.getLocation())){
            throw new Exception("Please enter a valid move");
        }
        Square fromSq = this.getCurrentSquare();
        move(square,board);
        List<Piece>pieces = this.isWhite()?board.getWhitePieces():board.getBlackPieces();
        King king = null;
        if (this.getType().equals(PiecesType.KING)){
            king = (King) this;
        }
        else {
            for (Piece piece : pieces) {
                if (piece.getType().equals(PiecesType.KING)) {
                    king = (King) piece;
                }
            }
        }
        if (king.isInCheck(board)){
            move(fromSq,board);
            throw new Exception("Your king is checked , please enter a valid move");

        }



    }
    public void move(Square square,Board board){
        this.currentSquare.reset();
        square.setCurrentPiece(this);
        square.setOccupied(true);
        this.setCurrentSquare(square);
    }

    @Override
    public String toString() {
        return "Piece{" +
                "type=" + type +
                ", currentSquare=" + currentSquare +
                ", isWhite=" + isWhite +
                '}';
    }
}
