package Pieces;

import Squares.Location;
import Squares.LocationFactory;
import Squares.Square;
import enums.PiecesType;
import game.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Bishop extends Piece{
    public Bishop(boolean isWhite) {
        super(isWhite);
        type= PiecesType.BISHOP;
    }

    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> validMoves = new ArrayList<>();
        Map<Location, Square> squareMap = board.getLocationMap();
        Location current = this.getCurrentSquare().getLocation();
        getMoves(validMoves, squareMap, current, 1, 1);
        getMoves(validMoves, squareMap, current, 1, -1);
        getMoves(validMoves, squareMap, current, -1, -1);
        getMoves(validMoves, squareMap, current, -1, 1);
        return validMoves;


    }
    private void getMoves(
            List<Location> candidates,
            Map<Location, Square> squareMap,
            Location current,
            int rankOffset,
            int fileOffset) {
        try {
            Location next = LocationFactory.build(current, fileOffset, rankOffset);
            while (squareMap.containsKey(next)) {
                if (squareMap.get(next).isOccupied()) {
                    if (squareMap.get(next).getCurrentPiece().isWhite()==this.isWhite()) break;
                    candidates.add(next);
                    break;
                }
                candidates.add(next);
                next = LocationFactory.build(next, fileOffset, rankOffset);
            }
            for (int i=1;i<candidates.size();i++){
                if (candidates.get(i).getFile() == candidates.get(i-1).getFile()||candidates.get(i).getFile().equals(this.getCurrentSquare().getLocation().getFile())){
                    candidates.remove(i);
                }
            }
        } catch (Exception e) { }
    }
}
