package game.resultIO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import game.jsonStructurClasses.Gameplay;
import game.jsonStructurClasses.PlayerDeserializer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadJSON {

    public static void main(String[] args) {
        try (JsonReader reader = new JsonReader(new FileReader(".\\XJSON\\gameSteps_Ali_Bob1647768573148.json"))) {

            Gson gson=new Gson();


            gson = new GsonBuilder()
                    .registerTypeAdapter(Gameplay.class, new PlayerDeserializer())
                    .create();
            Gameplay bandIsBack = gson.fromJson(reader, Gameplay.class);
System.out.println(bandIsBack.getPlayer().get(0).getName());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
