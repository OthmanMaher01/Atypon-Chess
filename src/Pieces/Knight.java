package Pieces;

import Squares.Location;
import Squares.LocationFactory;
import Squares.Square;
import enums.PiecesType;
import game.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Knight extends Piece{
    @Override
    public List<Location> getValidMoves(Board board, Square square) {
        return null;
    }

    public Knight(boolean isWhite) {
        super(isWhite);
        type= PiecesType.KNIGHT;
    }

    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> moves = new ArrayList<>();
        Map<Location, Square> squareMap = board.getLocationMap();
        Location current = this.getCurrentSquare().getLocation();
        moves.add(LocationFactory.build( current,1, 2));
        moves.add(LocationFactory.build( current, -1, 2));
        moves.add(LocationFactory.build( current,1, -2));
        moves.add(LocationFactory.build( current,-1, -2));
        moves.add(LocationFactory.build( current,2, 1));
        moves.add(LocationFactory.build( current,-2, 1));
        moves.add(LocationFactory.build( current,2, -1));
        moves.add(LocationFactory.build( current,-2, -1));
        List<Location> validMoves = moves.stream().filter(squareMap::containsKey).toList();
        System.out.println(validMoves);
        return validMoves;


    }
}
