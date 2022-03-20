package game.jsonStructurClasses;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import game.Player;
import java.lang.reflect.Type;


public class PlayerDeserializer implements JsonDeserializer<Gameplay> {
    @Override
    public Gameplay deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

    JsonElement Gameplay=jsonElement.getAsJsonObject().get("Gameplay");
    JsonElement Player=Gameplay.getAsJsonObject().get("Player");

    JsonElement Player1=Player.getAsJsonArray().get(0);
    JsonElement Player2=Player.getAsJsonArray().get(1);

        Player playerObject1=new Player();
        playerObject1.setId(Integer.parseInt(Player1.getAsJsonObject().get("id").toString()));
        playerObject1.setName(trimSymbols(Player1.getAsJsonObject().get("name").toString()));
        playerObject1.setSymbolWithoutMessage(trimSymbols(Player1.getAsJsonObject().get("symbol").toString()));

        Player playerObject2=new Player();
        playerObject2.setId(Integer.parseInt(Player2.getAsJsonObject().get("id").toString()));
        playerObject2.setName(trimSymbols(Player2.getAsJsonObject().get("name").toString()));
        playerObject2.setSymbolWithoutMessage(trimSymbols(Player2.getAsJsonObject().get("symbol").toString()));

        System.out.println(playerObject2.getName());

        Gameplay gameplay=new Gameplay();
        gameplay.setPlayers(playerObject1);
        gameplay.setPlayers(playerObject2);

        return gameplay;
    }

    private static String trimSymbols(String s){
        return s.replaceAll("\"","");
    }
}
