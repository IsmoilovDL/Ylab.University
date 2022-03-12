package game.resultIO;

import game.GameStep;
import game.Player;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteResult {
    private static final String failPath="C:\\Users\\Admin\\Desktop\\Ylab.University\\Lesson-3\\src\\game\\XML\\";

    public void write(Player playerWinner, Player player2, ArrayList<GameStep> steps) {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = null;
        String fileName=failPath+"gameSteps_"+playerWinner.getName()+"_"+player2.getName()+".xml";
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            writer = factory.createXMLStreamWriter(fileWriter);
            writer.writeStartDocument();
            writer.writeStartElement("Gameplay");

            //Добавляем данные первого игрока
            writer.writeEmptyElement("Player");
                writer.writeAttribute("id", String.valueOf(playerWinner.getId()));
                writer.writeAttribute("name", playerWinner.getName());
                writer.writeAttribute("symbol", playerWinner.getSymbol());

            //Добавляем данные второго игрока
            writer.writeEmptyElement("Player");
                writer.writeAttribute("id", String.valueOf(player2.getId()));
                writer.writeAttribute("name", player2.getName());
                writer.writeAttribute("symbol", player2.getSymbol());


            writer.writeStartElement("Game");
            for(GameStep step: steps) {
                writer.writeStartElement("Step ");
                writer.writeAttribute("num", String.valueOf(step.getId()));
                writer.writeAttribute("playerId", String.valueOf(step.getPlayerId()));
                writer.writeCharacters(String.valueOf(step.getRow())+" "+String.valueOf(step.getColumn()));
                writer.writeEndElement();
            }
            writer.writeEndElement();


            writer.writeStartElement("GameResult");
                writer.writeEmptyElement("Player");
                    writer.writeAttribute("id", String.valueOf(playerWinner.getId()));
                    writer.writeAttribute("name", playerWinner.getName());
                    writer.writeAttribute("symbol", playerWinner.getSymbol());
            writer.writeEndElement();

            writer.writeEndElement();
            writer.writeEndDocument();

            writer.flush();
            writer.close();
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }
}
