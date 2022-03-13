package game;

import game.resultIO.ReadResult;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.nio.file.Paths;

public class GameHistory {
    private static final String FILENAME = "C:\\Users\\Admin\\Desktop\\Ylab.University\\Lesson-3\\src\\game\\XML\\gameSteps_Bob_Mike.xml";

    public static void main(String[] args) {
        showSteps(FILENAME);
    }

    public static void showSteps(String path){

        ReadResult result=new ReadResult(path);
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
        Player player3=result.getPlayersList().get(2);

        System.out.println("Player -> "+player3.getName()+" is winner as '"+player3.getSymbol()+"'! ");
    }
}
