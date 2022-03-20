package game.jsonStructurClasses;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import game.GameStep;
import game.Player;
import java.lang.reflect.Type;
import java.util.ArrayList;


public class PlayerDeserializer implements JsonDeserializer<Gameplay> {
    @Override
    public Gameplay deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

    JsonElement Gameplay=jsonElement.getAsJsonObject().get("Gameplay");

    //Получаем JSON объект игроков
    JsonElement Player=Gameplay.getAsJsonObject().get("Player");
    JsonElement Player1=Player.getAsJsonArray().get(0);
    JsonElement Player2=Player.getAsJsonArray().get(1);

        //Добавляем первого игрока
        Player playerObject1=new Player();
        playerObject1.setId(Integer.parseInt(Player1.getAsJsonObject().get("id").toString()));
        playerObject1.setName(trimSymbols(Player1.getAsJsonObject().get("name").toString()));
        playerObject1.setSymbolWithoutMessage(trimSymbols(Player1.getAsJsonObject().get("symbol").toString()));

        //Добавляем второго игрока
        Player playerObject2=new Player();
        playerObject2.setId(Integer.parseInt(Player2.getAsJsonObject().get("id").toString()));
        playerObject2.setName(trimSymbols(Player2.getAsJsonObject().get("name").toString()));
        playerObject2.setSymbolWithoutMessage(trimSymbols(Player2.getAsJsonObject().get("symbol").toString()));

        Gameplay gameplay=new Gameplay();
        gameplay.setPlayers(playerObject1);
        gameplay.setPlayers(playerObject2);

        //Получаем список ходов
        JsonElement Step=Gameplay.getAsJsonObject().get("Game").getAsJsonObject().get("Step");

        ArrayList<GameStep> steps=new ArrayList<>();
        GameStep stepItem;
        for (int i=0; i<Step.getAsJsonArray().size(); i++){
            JsonElement stepAtributs= Step.getAsJsonArray().get(i);
            int num = Integer.parseInt(stepAtributs.getAsJsonObject().get("num").toString());
            int playerId = Integer.parseInt(stepAtributs.getAsJsonObject().get("playerId").toString());
            String[] rowColumn= trimSymbols(stepAtributs.getAsJsonObject().get("text").toString()).split(" ");

            stepItem=new GameStep(Integer.parseInt(rowColumn[0]), Integer.parseInt(rowColumn[1]),"","", playerId);
            steps.add(stepItem);
        }
        gameplay.setSteps(steps);
        return gameplay;
    }

    //удаляет кавычки в начале и в конце строки
    private static String trimSymbols(String s){
        return s.replaceAll("\"","");
    }
}
