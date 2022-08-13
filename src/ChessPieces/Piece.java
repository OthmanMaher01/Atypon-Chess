package ChessPieces;

public abstract class Piece {

    public int mX, mY;
    public Type type;

//    public Piece(int mX, int mY) {
//        this.mX = mX;
//        this.mY = mY;
//
//    }

//    public abstract boolean isValidPath(int finalX, int finalY);
//    public abstract int[][] drawPath(int startX, int startY, int finalX, int finalY);

    public Type getType(){
        return type;
    }




}
