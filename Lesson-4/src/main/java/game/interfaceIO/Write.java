package game.interfaceIO;

import game.GameStep;
import game.Player;

import java.util.ArrayList;

public interface Write {
    public void write(Player playerWinner, Player player2, ArrayList<GameStep> steps, boolean draw);
}
