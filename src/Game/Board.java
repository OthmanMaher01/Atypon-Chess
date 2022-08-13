package Game;

import ChessPieces.Piece;

import java.util.Vector;

public class Board {
    public int height, width;
    public Vector<Piece> whitePieces = new Vector<Piece>(16);
    public Vector<Piece> blackPieces = new Vector<Piece>(16);
    public Piece[][] boardArray;

    public Board(int height, int width)
    {
        this.height = height;
        this.width = width;
        boardArray = new Piece[height][width];

    }

}
