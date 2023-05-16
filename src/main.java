import Pieces.Pawn;
import Squares.Location;
import Squares.Square;
import enums.ConsoleColor;
import enums.File;
import game.Board;
import game.ChessGame;

import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String args[])  //static method
    {
        ////hahahahahahahahahahahahahahahaahaasdns;jkfnasjdbfasdbfjksbdfjob
        new ChessGame().start();
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
    }
}
