package webApp.controller;

import com.google.gson.Gson;
import game.Player;
import game.game;
import game.gameTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/gameplay")
public class GameplayController {
ArrayList<Player> players=new ArrayList<>();
    @GetMapping
    public String index(){
        return "Index Page";
    }

    @GetMapping("new")
    public String newGame(){
       game game=new game();
        game.setGameTable(new gameTable());
        game.setPlayer1(players.get(0));
        game.setPlayer2(players.get(1));

        Gson gson=new Gson();
        return gson.toJson(game);
    }

    @PostMapping("player")
    public String newPlayer(@RequestParam String text){
        Player player=new Player();
        player.setName(text);
        Gson gson=new Gson();

        players.add(player);
        return gson.toJson(player);
    }

    @GetMapping("players")
    public String playerSList(){
        Gson gson=new Gson();
        return gson.toJson(players);
    }
}
