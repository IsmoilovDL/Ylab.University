package TicTacToe.utils.interfaceIO;

import TicTacToe.utils.GameStep;
import TicTacToe.sevices.player.Player;
import java.util.ArrayList;

public interface Write {
    public void write(Player playerWinner, Player player2, ArrayList<GameStep> steps, boolean draw);
}
