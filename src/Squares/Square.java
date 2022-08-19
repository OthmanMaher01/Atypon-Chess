package Squares;

import Pieces.Piece;
import enums.ChessColors;

import java.awt.*;

public class Square {
    private final ChessColors color;
    private final Location location;
    private boolean isOccupied;

    private Piece currentPiece;

    public Square(ChessColors color, Location location) {
        this.color = color;
        this.location = location;
        this.isOccupied=false;
    }
    public void reset() {
        this.isOccupied = false;
        this.currentPiece = null;
    }
    public ChessColors getColor() {
        return color;
    }
    public Location getLocation() {
        return location;
    }
    public void setCurrentPiece(Piece currentPiece) {
        this.currentPiece = currentPiece;
    }
    public Piece getCurrentPiece() {
        return currentPiece;
    }
    public boolean isOccupied() {
        return isOccupied;
    }
    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
