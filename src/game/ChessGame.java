package game;

import Squares.Location;
import Squares.Square;
import enums.File;
import player.Player;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class ChessGame {
    private Player whitePlayer;
    private Player blackPlayer;
    private Board board;
    private boolean isWhiteTurn=true;
    Scanner scanner = new Scanner(System.in);

    public ChessGame(){
        board=new Board();
        System.out.println("Enter the white player name: ");
        String whiteName = scanner.nextLine();

        System.out.println(whiteName);
        System.out.println("Enter the black player name: ");
        whitePlayer = new Player(whiteName,true);
        String blackName = scanner.nextLine();
        blackPlayer=new Player(blackName,false);
        System.out.println(blackName);


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
//        File[] files = File.values();
//        //check if the input is valid
        if (!mv.equals("move")&& !firstMove.matches("[a-h][1-8]") || !secondMove.matches("[a-h][1-8]")){
            throw new IllegalStateException("validate input");
        }
//
        return arrOfLines;

//        File fromFile=File.valueOf(String.valueOf(Character.toUpperCase(firstMove.charAt(0))));
//        int fromRank = Integer.parseInt(String.valueOf(firstMove.charAt(1)));
//        File toFile=File.valueOf(String.valueOf(Character.toUpperCase(secondMove.charAt(0))));
//        int toRank = Integer.parseInt(String.valueOf(secondMove.charAt(1)));
//         Square fromSq = board.getLocationMap().get(new Location(fromFile,fromRank));
//         Square toSq = board.getLocationMap().get(new Location(toFile,toRank));
//
//        if (!(fromSq.isOccupied() && isWhiteTurn && fromSq.getCurrentPiece().isWhite())){
//            throw new IllegalStateException();
//        }



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

            //validate squares and the pieces

//            File fromFile=File.valueOf(String.valueOf(Character.toUpperCase(from.charAt(0))));
//            int fromRank = Integer.parseInt(String.valueOf(from.charAt(1)));
//            File toFile=File.valueOf(String.valueOf(Character.toUpperCase(to.charAt(0))));
//            int toRank = Integer.parseInt(String.valueOf(to.charAt(1)));
//            Square fromSq = board.getLocationMap().get(new Location(fromFile,fromRank));
//            Square toSq = board.getLocationMap().get(new Location(toFile,toRank));
//            Square fromSq=new Square(),toSq;
//            takePlayerInput(fromSq,toSq);
//            isWhiteTurn = !isWhiteTurn;
//            board.printBoard();

        }
    }
}
 /* Board board = new Board();
        board.printBoard();
        Scanner scanner = new Scanner(System.in);
        while(true){
            String line = scanner.nextLine();
            String[] fromTo = line.split("->");
            File fromFile=File.valueOf(String.valueOf(Character.toUpperCase(fromTo[0].charAt(0))));
            int fromRank = Integer.parseInt(String.valueOf(fromTo[0].charAt(1)));
            File toFile=File.valueOf(String.valueOf(Character.toUpperCase(fromTo[1].charAt(0))));
            int toRank = Integer.parseInt(String.valueOf(fromTo[1].charAt(1)));
            Square fromSq = board.getLocationMap().get(new Location(fromFile,fromRank));
            Square toSq = board.getLocationMap().get(new Location(toFile,toRank));
            try {
                fromSq.getCurrentPiece().movePiece(toSq,board);
            }catch (Exception e){

                System.out.println("Try again");
                continue;
            }


            board.printBoard();


        }*/