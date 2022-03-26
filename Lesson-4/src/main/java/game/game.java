package game;

public class game {
    private Player player1;
    private Player player2;
    private gameTable gameTable;
    private int id;

    public game(){
        id++;
    }

    public int getId(){
        return id;
    }
    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        player1.setSymbolWithoutMessage("X");
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        player2.setSymbolWithoutMessage("0");
        this.player2 = player2;
    }

    public gameTable getGameTable() {
        return gameTable;
    }

    public void setGameTable(gameTable gameTable) {
        this.gameTable = gameTable;
    }



}
