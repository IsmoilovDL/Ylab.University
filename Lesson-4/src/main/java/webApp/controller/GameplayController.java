package webApp.controller;

import com.google.gson.Gson;
import game.Player;
import game.game;
import game.gameTable;
import game.GameStep;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/gameplay")
public class GameplayController {
    Gson gson=new Gson();
    game game=new game();
    ArrayList<Player> players=new ArrayList<>();
    ArrayList<GameStep> steps=new ArrayList<>();

    @GetMapping
    public String index(){
        return "Index Page";
    }

    @GetMapping("new")
    public String newGame(){
        game.setGameTable(new gameTable());
        game.setPlayer1(players.get(0));
        game.setPlayer2(players.get(1));

        return gson.toJson(game);
    }

    @PostMapping("player")
    public String newPlayer(@RequestParam String name){
        Player player=new Player();
        player.setName(name);

        players.add(player);
        return gson.toJson(player);
    }

    @GetMapping("players")
    public String playerSList(){
        return gson.toJson(players);
    }

    @GetMapping("/current-step")
    public String currentStep(){
        int stepSize=steps.size();
        if(stepSize==0){
            return gson.toJson(players.get(0));
        }else if(steps.get(stepSize-1).getPlayerId()==1){
            return gson.toJson(players.get(1));
        }else {
            return gson.toJson(players.get(0));
        }


    }

    @PostMapping("step")
    public String step(@RequestParam int playerId, @RequestParam int row, @RequestParam int column){
       gameTable table= game.getGameTable();
       Player player;
       if(playerId==1){
           player=game.getPlayer1();
       } else {
           player=game.getPlayer2();
       }
       if(table.getPosition(row,column)!=null){
           return "Ячейка заята, выберити другую!";
       }

        table.setPosition(row,column,player.getSymbol());
        steps.add(new GameStep(row,column, player.getName(), player.getSymbol(), player.getId()));
        if(game.getGameTable().searchWinner(player.getSymbol())){
            return "Palyer: "+player.getName()+" win!";
        }
        return gson.toJson(table.getTableArray());

    }

}
