package Pieces;

import Squares.Square;
import enums.PiecesType;

public abstract class Piece implements Movable{

    public PiecesType type;
    private Square currentSquare;
    private final boolean isWhite;
    private boolean isAlive;

    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
        this.isAlive=true;
    }


    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
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
}
