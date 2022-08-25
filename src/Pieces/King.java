package Pieces;

import Squares.Location;
import Squares.Square;
import enums.PiecesType;
import game.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class King extends Piece {
    private final Piece bishop;
    private final Piece rook;
    private boolean isChecked;


    public King(boolean isWhite) {
        super(isWhite);
        type = PiecesType.KING;
        bishop = new Bishop(isWhite);
        rook = new Rook(isWhite);
        isChecked = false;
    }

    @Override
    public List<Location> getValidMoves(Board board, Square square) {
        return null;
    }

    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> validMoves = new ArrayList<>();
        validMoves.addAll(rook.getValidMoves(board, this.getCurrentSquare()));
        validMoves.addAll(bishop.getValidMoves(board, this.getCurrentSquare()));
        Location current = this.getCurrentSquare().getLocation();
        return validMoves.stream().filter(move->{
            if(Math.abs(move.getFile().ordinal()-current.getFile().ordinal())==1 && Math.abs(move.getRank()- current.getRank())==1){
                return true;
            }
            if(Math.abs(move.getFile().ordinal()-current.getFile().ordinal())==0 && Math.abs(move.getRank()- current.getRank())==1){
                return true;
            }
            return false;
        }).collect(Collectors.toList());



    }


//    public boolean isInCheckmate(Board board)
//    {
//        Vector<Piece> enemies = this.player.getEnemyPieces(this.player.playerColor);
//        Vector<Piece> attackingEnemies = new Vector<Piece>(1);
//
//        for(int i = 0; i < enemies.size(); i++)
//        {
//            if(enemies.elementAt(i).getType() != Type.KING && canKillKing(enemies.elementAt(i), this.x, this.y))
//            {
//                kingInCheck = true;
//                /*
//                 * if there's more than one enemy that can kill the king in a given space,
//                 * an ally cannot defend against both, and it cannot defend against knights.
//                 */
//                if(attackingEnemies.size() < 2 && enemies.elementAt(i).getType() != Type.KNIGHT)
//                {
//                    //keep a list of attacking enemies to potentially require an ally to defend against
//                    attackingEnemies.add(enemies.elementAt(i));
//                }
//            }
//        }
//
//        if(!kingCanMove(this.x, this.y)
//                && !kingCanMove(this.x + 1, this.y)
//                && !kingCanMove(this.x + 1, this.y + 1)
//                && !kingCanMove(this.x + 1, this.y - 1)
//                && !kingCanMove(this.x - 1, this.y)
//                && !kingCanMove(this.x - 1, this.y + 1)
//                && !kingCanMove(this.x - 1, this.y - 1)
//                && !kingCanMove(this.x + 1, this.y + 1))
//        {
//            //if(allyCanDefend(attackingEnemies))
//            //return false;
//
//
//            return true;
//
//        }
//        return false;
//    }

}
