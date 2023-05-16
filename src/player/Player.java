package player;

import Pieces.King;

import java.util.Scanner;

public class Player {
    private final String name;
    private final Boolean isWhite;
// this is zain
    public Player(String name, Boolean isWhite) {
        this.name = name;
        this.isWhite = isWhite;
    }

    public Boolean isWhite() {
        return isWhite;
    }

    public String getName() {
        return name;
    }

}
