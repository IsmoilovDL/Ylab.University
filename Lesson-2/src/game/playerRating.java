package game;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class playerRating {
    private static final String failPath="C:\\Users\\Admin\\Desktop\\Ylab.University\\Lesson-2\\src\\game\\rating.txt";

    public static void main(String[] args) {
        playerRating p=new playerRating();
       // System.out.println( p.showRating());
        p.saveReting("Игрок33");
    }

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


    public void saveReting(String name){
        HashMap players=showRating();

        if(players.get(name)!=null){
            players.put(name, (int)players.get(name)+1);
        }
        else {
            players.put(name, 1);
        }
    }

}
