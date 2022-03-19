package game.resultIO;
import game.GameStep;
import game.Player;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReadResult {

    public ReadResult(String filePath){
        try {
            ReadXMLFile(Paths.get(filePath));

        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }



    private ArrayList<Player> playersList;
    private ArrayList<GameStep> stepsList;

    public ArrayList<Player> getPlayersList() {
        return playersList;
    }

    public ArrayList<GameStep> getStepsList() {
        return stepsList;
    }

    private void ReadXMLFile(Path path)
            throws FileNotFoundException, XMLStreamException {

        playersList=new ArrayList<>();
        stepsList=new ArrayList<>();

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(
                new FileInputStream(path.toFile()));

        int eventType = reader.getEventType();

        while (reader.hasNext()) {

            eventType = reader.next();

            if (eventType == XMLEvent.START_ELEMENT) {

                switch (reader.getName().getLocalPart()) {

                    case "Player":
                        String id = reader.getAttributeValue(null, "id");
                        String name = reader.getAttributeValue(null, "name");
                        String symbol = reader.getAttributeValue(null, "symbol");

                        Player player =new Player();
                        player.setId(Integer.parseInt(id));
                        player.setName(name);
                        player.setSymbolWithoutMessage(symbol);
                        playersList.add(player);

                        break;

                    case "Step":
                        String num = reader.getAttributeValue(null, "num");
                        String PlayerId = reader.getAttributeValue(null, "playerId");
                        String value= reader.getElementText();
                        String[] rowColumn=value.split(" ");
                        GameStep step=new GameStep(Integer.parseInt(rowColumn[0]),Integer.parseInt(rowColumn[1]), "", "", Integer.parseInt(PlayerId));
                        stepsList.add(step);
                        break;

                }

            }



        }

    }
}
