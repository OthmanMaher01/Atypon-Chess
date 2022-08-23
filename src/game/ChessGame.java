package game;

import Squares.Location;
import Squares.Square;
import enums.File;
import player.Player;


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
    public void validateSquare(Square fromSq){
     //   System.out.println(!(fromSq.isOccupied() && isWhiteTurn && fromSq.getCurrentPiece().isWhite()));

               if (!(isWhiteTurn==fromSq.getCurrentPiece().isWhite())){
               // if (!(fromSq.isOccupied() && isWhiteTurn && fromSq.getCurrentPiece().isWhite())){
            throw new IllegalStateException("validate square");
        }


    }
    // return array of string and use it
    public String[] takePlayerInput(){
        System.out.print("Enter next move ("+(isWhiteTurn?"white player":"black player")+"): ");
        String line  = scanner.nextLine();
        String[] arrOfLines = line.split("\\s+");
        Map<Location, Square> squareMap = board.getLocationMap();
        if (arrOfLines.length != 3){
            throw new IllegalStateException();
        }
        String mv=arrOfLines[0];
        String firstMove=arrOfLines[1];
        String secondMove= arrOfLines[2];
        if (!mv.equals("move")&& !firstMove.matches("[a-h][1-8]") || !secondMove.matches("[a-h][1-8]")){
            throw new IllegalStateException("validate input");
        }
        return arrOfLines;
    }
    public void start(){
        board.printBoard();
        while(true) {
            try {
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
                System.out.println(e);
                System.out.println("Please enter valid move");
            }
        }
    }
}
