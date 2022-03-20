package game.resultIO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import game.jsonStructurClasses.Gameplay;
import game.jsonStructurClasses.PlayerDeserializer;
import game.jsonStructurClasses.Step;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadJSON {

    public static void main(String[] args) {
        try (JsonReader reader = new JsonReader(new FileReader(".\\XJSON\\gameSteps_Ali_Bob1647768573148.json"))) {

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Gameplay.class, new PlayerDeserializer())
                    .create();
            Gameplay bandIsBack = gson.fromJson(reader, Gameplay.class);

            System.out.println(bandIsBack.getGame().get(0).getNum());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
