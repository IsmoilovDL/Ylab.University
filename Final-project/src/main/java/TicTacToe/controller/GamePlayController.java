package TicTacToe.controller;

import TicTacToe.model.GameHistory;
import TicTacToe.model.Rating;
import TicTacToe.model.StepsHistory;
import TicTacToe.repository.GameHistoryRep;
import TicTacToe.repository.PlayerRep;
import TicTacToe.repository.RatingRep;
import TicTacToe.repository.StepsHistoryRep;
import TicTacToe.sevices.Game;
import TicTacToe.sevices.gameLogic.CurrentStep;
import TicTacToe.sevices.gameLogic.GameTable;
import TicTacToe.model.Player;
import TicTacToe.utils.GameStep;
import TicTacToe.utils.resultIO.WriteJSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/gameplay")
@CrossOrigin
public class GamePlayController{
    @Autowired
    private RatingRep ratingRep;

    @Autowired
    private PlayerRep playerRep;

    @Autowired
    private GameHistoryRep gameHistoryRep;

    @Autowired
    private StepsHistoryRep stepsHistoryRep;


    Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
    Game game=new Game();

    /**
     * список игроков
     */
    ArrayList<Player> players=new ArrayList<>();

    /**
     * HashMap используется для хранения символа игроков
     */
    HashMap<Integer, String> playerSymbols =new HashMap<>();

    /**
     * Список соверщенных ходов в текущей игре
     */
    ArrayList<GameStep> steps=new ArrayList<>();

    /**
     * Класс для записи ходов в JSON файл
     */
    WriteJSON writeJSON=new WriteJSON();

    @GetMapping
    public String index(){
        return "Index Page";
    }

    @GetMapping("new")
    public String newGame(){
        game.setGameTable(new GameTable());
        ArrayList<Integer> playersId=new ArrayList<>();
        for (Player player:playerRep.findAll()) {
            playersId.add(player.getId());
        }

        Player p1=playerRep.findById(playersId.get(0)).get();
        game.setPlayer1(p1);
        players.add(p1);
        playerSymbols.put(p1.getId(),"X");

        Player p2 =playerRep.findById(playersId.get(1)).get();
        game.setPlayer2(p2);
        players.add(p2);
        playerSymbols.put(p2.getId(),"0");

        return gson.toJson(game);
    }



    @PostMapping("player")
    public void newPlayer(@RequestParam String name){
        Player player=new Player();
        player.setName(name);
        Rating rating=new Rating();
        rating.setPlayer_rating(0);
        player.setRating(rating);
        playerRep.save(player);

    }

    @GetMapping("players")
    public String playerSList(){
        return gson.toJson(playerRep.findAll());
    }

    @GetMapping("/current-step")
    public String currentStep(){
        return gson.toJson(CurrentStep.currentStep(steps, players));
    }

    @PostMapping("step")
    public String step(@RequestParam int playerId, @RequestParam int row, @RequestParam int column){
        GameTable table= game.getGameTable();
        Player player =playerRep.findById(playerId).get();
        String playerSymbol= playerSymbols.get(player.getId());

        String result =CurrentStep.setStep(playerId, row, column, table, player, playerSymbol,
                game, steps, players);

        if(result.indexOf("win")!=-1){
           int currentRating= player.getRating().getPlayer_rating();
           Rating rating=new Rating();
           rating.setId(player.getRating().getId());
           rating.setPlayer_rating(currentRating+2);
           player.setRating(rating);
           playerRep.save(player);


            SaveSteps(players.get(0).getName(), players.get(1).getName(), steps);

           steps=new ArrayList<>();

        }
        if(result.indexOf("draw")!=-1 ){
            steps=new ArrayList<>();
        }
        return result;

    }


    /**
     * Сохраняет историю игры
     * @param playerOneName игрок 1
     * @param playerTwoName игрок 2
     * @param stepsList список ходов игры тип ArrayList<GameStep>
     */
    private void SaveSteps(String playerOneName, String playerTwoName, ArrayList<GameStep> stepsList){

        Collection<StepsHistory> collection=new ArrayList<>();
        GameHistory gameHistory=new GameHistory();
        int count = 0;

        for (GameStep item:stepsList) {
            StepsHistory stepsHistory=new StepsHistory();
            stepsHistory.setPlayer_id(item.getPlayerId());
            stepsHistory.setPosition_col(item.getColumn());
            stepsHistory.setPosition_row(item.getRow());
            stepsHistory.setStep_number(++count);
            stepsHistory.setSymbol(item.getSymbol());
            stepsHistory.setPrimaryGame(gameHistory);
            collection.add(stepsHistory);
        }
        gameHistory.setStepsHistories(collection);
        gameHistory.setPlayer1(playerOneName);
        gameHistory.setPlayer2(playerTwoName);

        gameHistoryRep.save(gameHistory);
    }
}
