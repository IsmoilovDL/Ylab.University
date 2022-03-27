package game.jsonStructurClasses;

import game.GameStep;
import game.Player;

import java.util.ArrayList;

//классы используются для сохранение JSON в нужном выде
public class Gameplay {
    private ArrayList<game.Player> Player=new ArrayList<>();
    private Game Game;
    private Winner GameResult;

    //Список игроков
    public void setPlayers(Player player) {
        Player.add(player);
    }

    //Список ходов
    public void setSteps(ArrayList<GameStep> steps) {
        this.Game=new Game(steps);
    }

    //Побидитель
    public void setWinnwer(Player player){
        GameResult=new Winner(player);
    }

    public ArrayList<game.Player> getPlayer() {
        return Player;
    }
    public ArrayList<Step>  getGame() {
        return this.Game.getStep();
    }
    public Player getWinner(){
        //Если нету победителя игры то возвращаем null
        try {
            return this.GameResult.getPlayer();
        }catch (NullPointerException exception){
            return null;
        }
    }
}

class Game{

    public ArrayList<Step> Step=new ArrayList<>();
    public ArrayList<Step> getStep() {
        return Step;
    }

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


