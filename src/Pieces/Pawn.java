package Pieces;

import Squares.Location;
import Squares.LocationFactory;
import Squares.Square;
import enums.PiecesType;
import game.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Pawn extends Piece {
    private boolean isFirstMove = true;

    @Override
    public List<Location> getValidMoves(Board board, Square square) {
        return null;
    }

    public Pawn(boolean isWhite) {
        super(isWhite);
        type = PiecesType.PAWN;
    }

    @Override
    public void movePiece(Square square, Board board) {
        super.movePiece(square, board);
        if (isFirstMove) {
            isFirstMove = false;
        }
    }

    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> moves = new ArrayList<>();
        Location currentLocation = this.getCurrentSquare().getLocation();
        int sign = (!isWhite()) ? -1 : 1;
        if (isFirstMove) {
            moves.add(LocationFactory.build(currentLocation, 0, 2*sign));
        }
        moves.add(LocationFactory.build(currentLocation, 0, sign));
        moves.add(LocationFactory.build(currentLocation, 1, sign));
        moves.add(LocationFactory.build(currentLocation, -1, sign));
        Map<Location, Square> squareMap = board.getLocationMap();
        List<Location> validMoves = moves.stream().filter(squareMap::containsKey).toList();
      return validMoves.stream().filter((move)-> {
          if (move.getFile().equals(currentLocation.getFile()) && squareMap.get(move).isOccupied()) {
              return false;
          }
        if(squareMap.get(move).getCurrentPiece() == null&& !move.getFile().equals(currentLocation.getFile())){
            return false;
        }
        if (squareMap.get(move).getCurrentPiece() != null&&squareMap.get(move).getCurrentPiece().isWhite()&&this.isWhite()){
            return false;
        }
        return true;
      }).collect(Collectors.toList());


    }
}

