package lr8.xml_example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XmlCreate {

    private static final String FILE_PATH = "src/lr8/xml_example/films.xml";

    public static void main(String[] args) throws Exception {
        new File("src/lr8/xml_example").mkdirs();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        Element cinema = doc.createElement("cinema");
        doc.appendChild(cinema);

        addFilm(doc, cinema, "Матрица", "Лана и Лилли Вачовски", "1999");
        addFilm(doc, cinema, "Начало", "Кристофер Нолан", "2010");

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.transform(new DOMSource(doc), new StreamResult(new File(FILE_PATH)));

        System.out.println("XML-файл успешно создан: " + FILE_PATH);
    }

    private static void addFilm(Document doc, Element parent, String title, String director, String year) {
        Element film = doc.createElement("film");
        parent.appendChild(film);

        Element titleEl = doc.createElement("title");
        titleEl.setTextContent(title);
        film.appendChild(titleEl);

        Element directorEl = doc.createElement("director");
        directorEl.setTextContent(director);
        film.appendChild(directorEl);

        Element yearEl = doc.createElement("year");
        yearEl.setTextContent(year);
        film.appendChild(yearEl);
    }
}
