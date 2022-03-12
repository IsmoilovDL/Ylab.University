package game;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class playerRating {
    private static final String failPath="C:\\Users\\Admin\\Desktop\\Ylab.University\\Lesson-3\\src\\game\\rating.txt";

    //вывод список игроков из файла
    public HashMap<String, Integer> showRating(){
        HashMap<String , Integer> playerList =new HashMap<>();

        try(FileReader reader = new FileReader(failPath))
        {

            Scanner scanner= new Scanner(reader);
            while (scanner.hasNext()){
                String line=scanner.nextLine();
                String[] array=line.split(" ");
                playerList.put(array[0], Integer.parseInt(array[1]));

            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return playerList;

    }


    //сохраняет в файл рейтинг игроков
    public void saveReting(String name){
        HashMap players=showRating();

        //проверка игрока на существование
        if(players.get(name)!=null){
            players.put(name, (int)players.get(name)+1);
        }
        else {
            players.put(name, 1);
        }

        //для сохранение в файл записиваем в строку
        Iterator<Map.Entry<String, Integer>> it = players.entrySet().iterator();
        StringBuilder dbWrite=new StringBuilder();
        while (it.hasNext()) {
            Map.Entry<String, Integer> pair = it.next();
            dbWrite.append(pair.getKey()+ " "+pair.getValue()+"\n");
        }
        //запись в файл
        try(FileWriter writer = new FileWriter(failPath))
        {
            writer.write(String.valueOf(dbWrite));

        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

}
