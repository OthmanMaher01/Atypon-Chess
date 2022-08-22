package Pieces;

import Squares.Location;
import Squares.LocationFactory;
import Squares.Square;
import enums.PiecesType;
import game.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Rook extends Piece{
    public Rook(boolean isWhite) {
        super(isWhite);
        type= PiecesType.ROOK;
    }

    @Override
    public List<Location> getValidMoves(Board board, Square square) {
        List<Location> validMoves = new ArrayList<>();
        Map<Location, Square> squareMap = board.getLocationMap();
        Location current = square.getLocation();
        getFileCandidates(validMoves, squareMap, current, -1);
        getFileCandidates(validMoves, squareMap, current, 1);
        getRankCandidates(validMoves, squareMap, current, -1);
        getRankCandidates(validMoves, squareMap, current, 1);
        System.out.println("Rook : "+validMoves);
        return validMoves;
    }

    private void getFileCandidates(
            List<Location> moveCandidates,
            Map<Location, Square> squareMap,
            Location current,
            int offset) {
        try {
            Location next = LocationFactory.build(current, offset, 0);
            while (squareMap.containsKey(next)) {
                if (squareMap.get(next).isOccupied()) {
                    if (squareMap.get(next).getCurrentPiece().isWhite()&&this.isWhite()) {
                        break;
                    }
                    moveCandidates.add(next);
                    break;
                }
                moveCandidates.add(next);
                next = LocationFactory.build(next, offset, 0);
            }
        } catch (Exception e) { }
    }

    private void getRankCandidates(
            List<Location> moveCandidates,
            Map<Location, Square> squareMap,
            Location current,
            int offset) {
        try {
            Location next = LocationFactory.build(current, current.getFile().ordinal(), offset);
            while (squareMap.containsKey(next)) {
                if (squareMap.get(next).isOccupied()) {
                    if (squareMap.get(next).getCurrentPiece().isWhite()&&this.isWhite()) {
                        break;
                    }
                    moveCandidates.add(next);
                    break;
                }
                moveCandidates.add(next);
                next = LocationFactory.build(next, next.getFile().ordinal(), offset);
            }
        } catch (Exception e) {

        }
    }


    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> validMoves = new ArrayList<>();
        Map<Location, Square> squareMap = board.getLocationMap();
        Location current = this.getCurrentSquare().getLocation();
        getFileCandidates(validMoves, squareMap, current, -1);
        getFileCandidates(validMoves, squareMap, current, 1);
        getRankCandidates(validMoves, squareMap, current, -1);
        getRankCandidates(validMoves, squareMap, current, 1);
        return validMoves;
    }
}
