package Players;

import ChessPieces.Piece;

public class Player {

    public String name;
    public Color playerColor;
    public Piece[][] playerPieces;
    public boolean isTurn = false;

    public Player(String name, Color playerColor) {
        this.name = name;
        this.playerColor = playerColor;
    }

    public Color getPlayerColor() {
        return playerColor;
    }

    public boolean isTurn() {
        return isTurn;
    }
}
