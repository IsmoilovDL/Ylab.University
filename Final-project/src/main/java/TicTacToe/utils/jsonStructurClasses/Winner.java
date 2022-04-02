package TicTacToe.utils.jsonStructurClasses;

import TicTacToe.sevices.player.Player;

 public class Winner{
    Player Player;
    public Winner(Player winner){
        this.Player=winner;
    }
    public Player getPlayer() {
        return Player;
    }
}