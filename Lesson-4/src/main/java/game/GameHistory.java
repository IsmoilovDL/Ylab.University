package game;

import game.resultIO.ReadXML;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class GameHistory {
    private static final String FILENAME = ".\\XML\\";

    public static void main(String[] args) {
        File directory=new File(FILENAME);
        File[] files=directory.listFiles();

        ArrayList<FilesList> list=new ArrayList<>();
        System.out.println("Список файлов игры:");
        int count=1;
        for (File name: files){
            FilesList filesList=new FilesList();
            filesList.setId(count);
            filesList.setName(name.getName());
            filesList.setPath(name.getPath());
            list.add(filesList);
            System.out.println(count+"-"+name.getName());
            count++;
        }

        System.out.println("Введите номер файла из списка");
        Scanner scanner=new Scanner(System.in);
        int number=scanner.nextInt();
        showSteps(list.get(number-1).getPath());
    }

    public static void showSteps(String path){

        ReadXML result=new ReadXML(path);
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
        if(result.getPlayersList().size()<3) {
            System.out.println("Draw!");
        }else {
            Player player3 = result.getPlayersList().get(2);
            System.out.println("Player -> " + player3.getName() + " is winner as '" + player3.getSymbol() + "'! ");
        }
    }
}
class FilesList{
    private int id;
    private String name;
    private String path;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


}