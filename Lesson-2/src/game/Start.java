package game;

import java.util.Arrays;

public class Start {
    public static void main(String[] args) {
        gameTable game =new gameTable();
        game.setPosition(0,0,"X");
        game.setPosition(1,1,"X");
        game.setPosition(2,2,"X");

        System.out.println(game.getTableXO());
        System.out.println(game.searchWinner("X"));

    }
}
