package webApp.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import game.GameStep;
import game.Player;
import game.gameTable;
import game.jsonStructurClasses.Gameplay;
import game.jsonStructurClasses.PlayerDeserializer;
import game.resultIO.ReadJSON;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("files")
public class GameController {
    @GetMapping
    public String list(){
        return "Index Page";
    }

    @PostMapping
    public String create(@RequestParam String text){

        ReadJSON result=new ReadJSON();
        result.readFileFromClient(text);


        Player player1=result.getPlayersList().get(0);
        Player player2=result.getPlayersList().get(1);

        gameTable gameTable=new gameTable();
        gameTable.newGame();

        int count=0;
        for (GameStep step:result.getStepsList()){
            int playerId=step.getPlayerId();
            System.out.printf("Step number: %s%n", ++count);
            if(playerId==player1.getId()){
                gameTable.setPosition(step.getRow()-1, step.getColumn()-1, player1.getSymbol());
                System.out.println(gameTable.getTableXO()+"\n");
            }
            else if(playerId==player2.getId()){
                gameTable.setPosition(step.getRow()-1, step.getColumn()-1, player2.getSymbol());
                System.out.println(gameTable.getTableXO()+"\n");
            }
        }

        if(result.getWinner()!=null){
            Player winner = result.getWinner();
            String gameResult="Player -> " + winner.getName() + " is winner as '" + winner.getSymbol() + "'! ";
            System.out.println(gameResult);
            return gameResult;

        }else {
            System.out.println("Draw!");
            return "Draw";

        }


    }


}
