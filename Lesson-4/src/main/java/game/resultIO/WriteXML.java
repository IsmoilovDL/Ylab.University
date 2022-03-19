package game.resultIO;

import game.GameStep;
import game.Player;
import game.interfaceIO.Write;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class WriteXML implements Write{
    private static final String failPath=".\\XML\\";

    @Override
    public void write(Player playerWinner, Player player2, ArrayList<GameStep> steps, boolean draw) {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = null;

        //генерируем имя файла
        Date date=new Date();
        String fileName=failPath+"gameSteps_"+playerWinner.getName()+"_"+player2.getName()+date.getTime()+".xml";

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


            if(draw){
                writer.writeStartElement("GameResult");
                    writer.writeCharacters("Draw!");
                writer.writeEndElement();
            }
            else {
                writer.writeStartElement("GameResult");
                writer.writeEmptyElement("Player");
                writer.writeAttribute("id", String.valueOf(playerWinner.getId()));
                writer.writeAttribute("name", playerWinner.getName());
                writer.writeAttribute("symbol", playerWinner.getSymbol());
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();

            writer.flush();
            writer.close();
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }
}
