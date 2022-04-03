package TicTacToe.utils.resultIO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonWriter;
import TicTacToe.utils.GameStep;
import TicTacToe.model.Player;
import TicTacToe.utils.interfaceIO.Write;
import TicTacToe.utils.jsonStructurClasses.Gameplay;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class WriteJSON implements Write {


    @Override
    public void write(Player playerWinner, Player player2, ArrayList<GameStep> steps, boolean draw) {
        Gameplay Gameplay=new Gameplay();
        Gameplay.setPlayers(playerWinner);
        Gameplay.setPlayers(player2);
        Gameplay.setSteps(steps);
        if(!draw) {
            Gameplay.setWinner(playerWinner);
        }
        Gson gson=new Gson();
        Gson gson1 = new GsonBuilder().setPrettyPrinting().create();
        JsonElement je = JsonParser.parseString(gson1.toJson(Gameplay));
        String prettyJsonString = gson1.toJson(je);
        Date date=new Date();

        try (JsonWriter writer = new JsonWriter(new FileWriter(".\\XJSON\\gameSteps_"+playerWinner.getName()+"_"+player2.getName()+date.getTime()+".json"))) {

            writer.beginObject();
            writer.name("Gameplay").jsonValue(prettyJsonString);
            writer.endObject();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

