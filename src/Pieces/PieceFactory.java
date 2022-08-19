package Pieces;

import Squares.Location;
import enums.File;

import java.util.HashMap;
import java.util.Map;

public final class PieceFactory {

    public static Map<Location, Piece> getPieces() {
        Map<Location,Piece> pieces = new HashMap<>();
        //King
        pieces.put(new Location(File.E,1), new King(true));
        pieces.put(new Location(File.E,8), new King(false));

        //Queen
        pieces.put(new Location(File.D,1), new Queen(true));
        pieces.put(new Location(File.D,8), new Queen(false));

        //Rooks
        pieces.put(new Location(File.A,1), new Rook(true));
        pieces.put(new Location(File.H,1), new Rook(true));
        pieces.put(new Location(File.A,8), new Rook(false));
        pieces.put(new Location(File.H,8), new Rook(false));

        //Knights
        pieces.put(new Location(File.B,1), new Knight(true));
        pieces.put(new Location(File.G,1), new Knight(true));
        pieces.put(new Location(File.B,8), new Knight(false));
        pieces.put(new Location(File.G,8), new Knight(false));

        //Bishops
        pieces.put(new Location(File.C,1), new Bishop(true));
        pieces.put(new Location(File.F,1), new Bishop(true));
        pieces.put(new Location(File.C,8), new Bishop(false));
        pieces.put(new Location(File.F,8), new Bishop(false));

        //Pawns
        for (File file : File.values()){
            pieces.put(new Location(file,2), new Pawn(true));
            pieces.put(new Location(file,7), new Pawn(false));
        }



        return pieces;
    }
}
