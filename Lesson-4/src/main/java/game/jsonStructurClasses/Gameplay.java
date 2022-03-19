package game.jsonStructurClasses;

import game.GameStep;
import game.Player;

import java.util.ArrayList;

//классы используются для сохранение JSON в нужном выде
public class Gameplay {
    private ArrayList<game.Player> Player=new ArrayList<>();
    private Game Game;
    private Winner GameResult;

    public void setPlayers(Player player) {
        Player.add(player);
    }

    public void setSteps(ArrayList<GameStep> steps) {
        Game=new Game(steps);
    }

    public void setWinnwer(Player player){
        GameResult=new Winner(player);
    }
}

class Game{
    public ArrayList<Step> Step=new ArrayList<>();

    public Game(ArrayList<GameStep> steps){
        int id=1;
        for (GameStep item:steps){
           Step step= new Step();
           step.setPlayerId(item.getPlayerId());
           step.setNum(id);
           step.setText(item.getRow()+" "+ item.getColumn());
           Step.add(step);
           id++;
        }
    };

}

class Step{
    public int num;
    public int playerId;
    public String text;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
class Winner{
    Player Player;
    public Winner(Player winner){
        this.Player=winner;
    }
}