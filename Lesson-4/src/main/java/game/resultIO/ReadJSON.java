package game.resultIO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import game.GameStep;
import game.Player;
import game.interfaceIO.Read;
import game.jsonStructurClasses.Gameplay;
import game.jsonStructurClasses.PlayerDeserializer;
import game.jsonStructurClasses.Step;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadJSON implements Read {
    private ArrayList<Player> playersList;
    private ArrayList<GameStep> stepsList;
    private Player winner;

    public ReadJSON(String filePath){
        readFile(filePath);
    }

    @Override
    public void readFile(String filePath) {
        try (JsonReader reader = new JsonReader(new FileReader(filePath))) {

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Gameplay.class, new PlayerDeserializer())
                    .create();
            Gameplay bandIsBack = gson.fromJson(reader, Gameplay.class);

            setPlayersList(bandIsBack.getPlayer());
            setStepsList(bandIsBack.getGame());
            if(bandIsBack.getWinner()!=null)
                setWinner(bandIsBack.getWinner());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setPlayersList(ArrayList<Player> players){
        this.playersList=players;
    }

    private void setWinner(Player winner){
        this.winner=winner;
    }

    private void setStepsList(ArrayList<Step> steps){
         ArrayList<GameStep> list=new ArrayList<>();
         for (Step item:steps){
             String[] rowColumn=item.getText().split(" ");
             GameStep gameStep=new GameStep(Integer.parseInt(rowColumn[0]), Integer.parseInt(rowColumn[1]),""
                     ,"", item.getPlayerId());
             list.add(gameStep);
         }
        this.stepsList=list;
    }

    public ArrayList<Player> getPlayersList() {
        return playersList;
    }

    public ArrayList<GameStep> getStepsList() {
        return stepsList;
    }

    public Player getWinner() {
        return winner;
    }
}
