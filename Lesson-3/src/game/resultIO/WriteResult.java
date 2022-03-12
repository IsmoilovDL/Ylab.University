package game.resultIO;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteResult {
    public static void main(String[] args) {
        WriteResult w =new WriteResult();
        try {
            w.write();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
    public void write() throws XMLStreamException {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = null;
        try (FileWriter fileWriter = new FileWriter("myoutput.xml")) {
            writer = factory.createXMLStreamWriter(fileWriter);
            writer.writeStartDocument();
            writer.writeStartElement("Gameplay");

            writer.writeStartElement("Player");
                writer.writeAttribute("id", "1");
                writer.writeAttribute("name", "Bob");
                writer.writeAttribute("symbol", "X");
            writer.writeEndElement();

            writer.writeStartElement("Game");
                writer.writeStartElement("Step ");
                    writer.writeAttribute("num", "1");
                    writer.writeAttribute("playerId", "1");
                writer.writeEndElement();
            writer.writeEndElement();


            writer.writeStartElement("GameResult");
                writer.writeEmptyElement("Player");
                    writer.writeAttribute("id", "1");
                    writer.writeAttribute("name", "Bob");
                    writer.writeAttribute("symbol", "X");
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
