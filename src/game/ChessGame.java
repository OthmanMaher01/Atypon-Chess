package game;

import Pieces.King;
import Pieces.Piece;
import Squares.Location;
import Squares.Square;
import enums.File;
import enums.PiecesType;
import player.Player;


import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ChessGame {
    private final Player whitePlayer;
    private final  Player blackPlayer;
    private Board board;
    private boolean isWhiteTurn=true;
    Scanner scanner = new Scanner(System.in);

    public ChessGame(){
        board=new Board();
        System.out.println("Enter the white player name: ");
        String whiteName = scanner.nextLine();
        System.out.println("Enter the black player name: ");
        whitePlayer = new Player(whiteName,true);
        String blackName = scanner.nextLine();
        blackPlayer=new Player(blackName,false);
    }
    public Square generateSquare(String sq){
        File file=File.valueOf(String.valueOf(Character.toUpperCase(sq.charAt(0))));
        int rank = Integer.parseInt(String.valueOf(sq.charAt(1)));
        return board.getLocationMap().get(new Location(file,rank));

    }
    public void validateSquare(Square fromSq) throws Exception {
               if (!(isWhiteTurn==fromSq.getCurrentPiece().isWhite())){
                   throw new Exception("Please choose one of your pieces");
        }


    }
    public String[] takePlayerInput() throws Exception {
        System.out.print("Enter next move ("+(isWhiteTurn?"white player":"black player")+"): ");
        String line  = scanner.nextLine();
        String[] arrOfLines = line.split("\\s+");
        Map<Location, Square> squareMap = board.getLocationMap();
        if (arrOfLines.length != 3){
            throw new Exception("Please enter a valid input");

        }
        String mv=arrOfLines[0];
        String firstMove=arrOfLines[1];
        String secondMove= arrOfLines[2];
        if (!mv.equals("move")&& !firstMove.matches("[a-h][1-8]") || !secondMove.matches("[a-h][1-8]")){
            throw new Exception("Please enter a valid input");
        }
        return arrOfLines;
    }
    public void start(){
        board.printBoard();
        while(true) {
            try {
                List<Piece> pieces = isWhiteTurn?board.getWhitePieces():board.getBlackPieces();
                King king = null;
                for (Piece piece : pieces) {
                    if (piece.getType().equals(PiecesType.KING)) {
                        king = (King) piece;
                    }
                }
                if (king.isInCheckMate(board)){
                    String color = isWhiteTurn?"White":"Black";
                    System.out.println(color+"Player wins");
                    break;
                }
                String[] inputs = takePlayerInput();
                String from = inputs[1];
                String to = inputs[2];
                Square fromSq = generateSquare(from);
                Square toSq = generateSquare(to);
                validateSquare(fromSq);
                fromSq.getCurrentPiece().movePiece(toSq, board);
                board.printBoard();
                isWhiteTurn=!isWhiteTurn;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
