package game;

import game.resultIO.ReadResult;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.nio.file.Paths;

public class GameHistory {
    private static final String FILENAME = "C:\\Users\\Admin\\Desktop\\Ylab.University\\Lesson-3\\src\\game\\XML\\gameSteps.xml";

    public static void main(String[] args) {

       ReadResult result=new ReadResult(FILENAME);
       Player player1=result.getPlayersList().get(0);
       Player player2=result.getPlayersList().get(1);

       System.out.println(result.getStepsList());


    }
}
