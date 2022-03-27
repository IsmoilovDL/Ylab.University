package game.jsonStructurClasses;

import game.Player;


 public class Winner{
    game.Player Player;
    public Winner(Player winner){
        this.Player=winner;
    }
    public game.Player getPlayer() {
        return Player;
    }
}