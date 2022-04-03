package TicTacToe.sevices.gameLogic;

import TicTacToe.model.Player;
import TicTacToe.utils.GameStep;

import java.util.ArrayList;

public class CurrentStep {
    public Player currentStep(ArrayList<GameStep> steps, ArrayList<Player> players){
        int stepSize=steps.size();

        if(stepSize==0){
            return players.get(0);

        }else if(steps.get(stepSize-1).getPlayerId()==players.get(0).getId()){

            return players.get(1);
        }else {

            return players.get(0);
        }

    }
}
