package TicTacToe.controller;

import TicTacToe.model.Rating;
import TicTacToe.repository.PlayerRep;
import TicTacToe.repository.RatingRep;
import TicTacToe.sevices.Game;
import TicTacToe.sevices.gameLogic.GameTable;
import TicTacToe.model.Player;
import TicTacToe.utils.GameStep;
import TicTacToe.utils.jsonStructurClasses.Message;
import TicTacToe.utils.resultIO.WriteJSON;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/gameplay")
@CrossOrigin
public class GamePlayController{
    @Autowired
    private RatingRep ratingRep;

    @Autowired
    private PlayerRep playerRep;

    Gson gson=new Gson();
    Game game=new Game();

    ArrayList<Player> players=new ArrayList<>();
    HashMap<Integer, String> pl=new HashMap<>();
    ArrayList<GameStep> steps=new ArrayList<>();
    WriteJSON writeJSON=new WriteJSON();

    @GetMapping
    public String index(){
        return "Index Page";
    }

    @GetMapping("new")
    public String newGame(){
        game.setGameTable(new GameTable());

        Player p1=playerRep.findById(2).get();
        game.setPlayer1(p1);
        players.add(p1);
        pl.put(p1.getId(),"X");

        Player p2 =playerRep.findById(4).get();
        game.setPlayer2(p2);
        players.add(p2);
        pl.put(p2.getId(),"0");

        return gson.toJson(game);
    }



    @PostMapping("player")
    public String newPlayer(@RequestParam String name){

        ratingRep.save(new Rating());
        Player player=new Player();
        player.setName(name);
        playerRep.save(player);

        return gson.toJson(player);
    }

    //выбрать записи из БД
    @GetMapping("players")
    public String playerSList(){
        return gson.toJson(playerRep.findAll());
    }

    @GetMapping("/current-step")
    public String currentStep(){
        int stepSize=steps.size();

        if(stepSize==0){
            return gson.toJson(players.get(0));

        }else if(steps.get(stepSize-1).getPlayerId()==players.get(0).getId()){

            return gson.toJson(players.get(1));
        }else {

            return gson.toJson(players.get(0));
        }


    }

    @PostMapping("step")
    public String step(@RequestParam int playerId, @RequestParam int row, @RequestParam int column){
        GameTable table= game.getGameTable();

        System.out.println(playerId);
        Player player =playerRep.findById(playerId).get();
        System.out.println(player.getId());

        if(table.getPosition(row,column)!=null){
            Message message=new Message();
            message.setType("error");
            message.setMessage("Ячейка заята, выберити другую!");
            return gson.toJson(message);
        }


        String playerSymbol=pl.get(player.getId());
        table.setPosition(row,column, playerSymbol);
        steps.add(new GameStep(row,column, player.getName(), playerSymbol, player.getId()));

        if(game.getGameTable().searchWinner(playerSymbol) || game.getGameTable().Draw()){

            Message message=new Message();
            if(game.getGameTable().Draw()){
                message.setType("draw");
                message.setMessage("Game is Draw!");
                writeJSON.write(players.get(0), players.get(1), steps,true);
                steps=new ArrayList<>();
            }
            else {
                message.setType("win");
                message.setMessage("Player " + player.getName() + " win by symbol " + playerSymbol);


                Player player2;
                if(player.getId()==1){
                    player2=players.get(1);
                }else {
                    player2=players.get(0);
                }
                writeJSON.write(player, player2, steps,false);
                steps=new ArrayList<>();

            }
            return gson.toJson(message);
        }

        return gson.toJson(table.getTableArray());

    }
}
