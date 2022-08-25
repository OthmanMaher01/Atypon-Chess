package game;

import Pieces.Piece;
import Pieces.PieceFactory;
import Squares.Location;
import Squares.Square;
import enums.ConsoleColor;
import enums.File;
import enums.ChessColors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private final Integer boardSize=8;
    private final Map<Location, Square> locationMap;
    Square[][] board= new Square[boardSize][boardSize];

    public List<Piece> getWhitePieces() {
        return whitePieces;
    }

    public List<Piece> getBlackPieces() {
        return blackPieces;
    }

    private final List<Piece> whitePieces = new ArrayList<>();
    private final List<Piece> blackPieces = new ArrayList<>();


    public Board() {
        locationMap = new HashMap<>();
        Map<Location,Piece>pieces = PieceFactory.getPieces();
        for (int i=0;i<board.length;i++){
            int column=0;
            ChessColors currentColor = (i % 2 == 0) ? ChessColors.WHITE : ChessColors.BLACK;
            for(File file : File.values()) {
                Square tempSquare = new Square(currentColor,new Location(file,boardSize-i));

                if (pieces.containsKey(tempSquare.getLocation())){
                    Piece piece = pieces.get(tempSquare.getLocation());
                    tempSquare.setCurrentPiece(piece);
                    tempSquare.setOccupied(true);
                    piece.setCurrentSquare(tempSquare);
                    if (piece.isWhite()) {
                        whitePieces.add(piece);
                    } else {
                        blackPieces.add(piece);
                    }
                }

                board[i][column]=tempSquare;
                locationMap.put(tempSquare.getLocation(),tempSquare);
                currentColor = (i % 2 == 0) ? ChessColors.WHITE : ChessColors.BLACK;
                column++;
            }
        }


    }

    public Map<Location, Square> getLocationMap() {
        return locationMap;
    }

    public void printBoard() {
        System.out.print("  ");
        for (File file : File.values()){
            System.out.print(ConsoleColor.RESET+file.name()+ "  ");
        }
        System.out.println(ConsoleColor.RESET);
        for (int i = 0; i < board.length; i++) {
            System.out.print(ConsoleColor.RESET);
            System.out.print(boardSize - i + " "+ConsoleColor.RESET);
            for (int j =0;j<board[i].length;j++){
                if (board[i][j].isOccupied()){
                    Piece piece = board[i][j].getCurrentPiece();
                    String pieceName = piece.getType().name();
                    if (piece.isWhite()) {
                        System.out.print(pieceName.charAt(0) + "" + pieceName.charAt(pieceName.length() - 1) + " ");
                    }
                    else {
                        System.out.print(ConsoleColor.BLACK+pieceName.charAt(0) + "" + pieceName.charAt(pieceName.length() - 1) + " ");

                    }
                }
                else {
                    System.out.print(ConsoleColor.RESET+"-  ");
                }
            }
            System.out.print(ConsoleColor.RESET);
            System.out.print(boardSize-i+ConsoleColor.RESET);

            System.out.println();

        }
        System.out.print("  ");
        for (File file : File.values()){
            System.out.print(file.name()+ "  ");
        }
        System.out.println();

    }
}
