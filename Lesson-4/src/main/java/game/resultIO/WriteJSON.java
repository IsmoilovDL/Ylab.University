package game.resultIO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonWriter;
import game.GameStep;
import game.Player;
import game.interfaceIO.Write;
import game.jsonStructurClasses.Gameplay;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteJSON implements Write {


    @Override
    public void write(Player playerWinner, Player player2, ArrayList<GameStep> steps, boolean draw) {
        Gameplay Gameplay=new Gameplay();
        Gameplay.setPlayers(playerWinner);
        Gameplay.setPlayers(player2);
        Gameplay.setSteps(steps);
        Gameplay.setWinnwer(playerWinner);
        Gson gson=new Gson();
        //System.out.println(gson.toJson(Gameplay));
        Gson gson1 = new GsonBuilder().setPrettyPrinting().create();
        JsonElement je = JsonParser.parseString(gson1.toJson(Gameplay));
        String prettyJsonString = gson1.toJson(je);

        try (JsonWriter writer = new JsonWriter(new FileWriter(".\\XJSON\\user.json"))) {

            writer.beginObject();
            writer.name("Gameplay").jsonValue(prettyJsonString);
            writer.endObject();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

