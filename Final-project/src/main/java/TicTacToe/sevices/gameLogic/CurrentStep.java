package TicTacToe.sevices.gameLogic;

import TicTacToe.model.Player;
import TicTacToe.model.Rating;
import TicTacToe.repository.PlayerRep;
import TicTacToe.repository.RatingRep;
import TicTacToe.sevices.Game;
import TicTacToe.utils.GameStep;
import TicTacToe.utils.jsonStructurClasses.Message;
import TicTacToe.utils.resultIO.WriteJSON;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;

public class CurrentStep {
    /**
     * Возвращает игрока который должен ходит следующим
     * @param steps список уже совершенных ходей
     * @param players список игроков
     * @return объект класса Player
     */
    public static Player currentStep(ArrayList<GameStep> steps, ArrayList<Player> players){
        int stepSize=steps.size();

        if(stepSize==0){
            return players.get(0);

        }else if(steps.get(stepSize-1).getPlayerId()==players.get(0).getId()){

            return players.get(1);
        }else {

            return players.get(0);
        }

    }
    /**
     * Класс для записи ходов в JSON файл
     */
    static WriteJSON writeJSON=new WriteJSON();
    static Gson gson=new Gson();


    /**
     *
     * @param playerId id игрока полученный по API
     * @param row номер строки в таблице
     * @param column номер столбца в таблице
     * @param table массив текущей игры
     * @param player игрок полученные по id
     * @param playerSymbol символ игрока
     * @param game текущая игра
     * @param steps список ходов
     * @param players список игроков
     * @return возвращает таблицу игры или резуальтат игры если ничья или есть побидитель
     */
    public static String setStep(int playerId, int row, int column, GameTable table,
                                 Player player, String playerSymbol, Game game, ArrayList<GameStep> steps, ArrayList<Player> players){

        if(table.getPosition(row,column)!=null){
            Message message=new Message();
            message.setType("error");
            message.setMessage("Ячейка заята, выберити другую!");
            return gson.toJson(message);
        }


        table.setPosition(row,column, playerSymbol);
        steps.add(new GameStep(row,column, player.getName(), playerSymbol, player.getId()));

        if(game.getGameTable().searchWinner(playerSymbol) || game.getGameTable().Draw()){

            Message message=new Message();
            if(game.getGameTable().Draw()){
                message.setType("draw");
                message.setMessage("Game is Draw!");
                writeJSON.write(players.get(0), players.get(1), steps,true);
            }
            else {
                message.setType("win");
                message.setMessage("Player " + player.getName() + " win by symbol " + playerSymbol);



                Player player2;
                if(player.getId()==players.get(0).getId()){
                    player2=players.get(1);
                }else {
                    player2=players.get(0);
                }
                writeJSON.write(player, player2, steps,false);

            }
            return gson.toJson(message);
        }

       return gson.toJson(table.getTableArray());
    }

}
