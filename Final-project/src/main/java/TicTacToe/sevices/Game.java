package TicTacToe.sevices;

import TicTacToe.sevices.gameLogic.GameTable;
import TicTacToe.sevices.player.Player;

public class Game {
    private Player player1;
    private Player player2;
    private GameTable gameTable;
    private int id;

    public Game(){
        id++;
    }

    public int getId(){
        return id;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        player1.setSymbol("X");
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        player2.setSymbol("0");
        this.player2 = player2;
    }

    public GameTable getGameTable() {
        return gameTable;
    }

    public void setGameTable(GameTable gameTable) {
        this.gameTable = gameTable;
    }



}
