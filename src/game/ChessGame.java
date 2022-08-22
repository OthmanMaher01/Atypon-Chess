package game;

import player.Player;

import java.util.Scanner;

public class ChessGame {
    private Player whitePlayer;
    private Player blackPlayer;
    private Board board;
    private boolean isWhiteTurn=true;
    Scanner scanner = new Scanner(System.in);

    public ChessGame(){
        System.out.println("Enter the white player name: ");
        String whiteName = scanner.nextLine();
        System.out.println(whiteName);
        System.out.println("Enter the black player name: ");
        String blackName = scanner.nextLine();
        System.out.println(blackName);


    }
    public void takePlayerInput(){
        String input = scanner.nextLine();

    }
    public void start(){
        board.printBoard();

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