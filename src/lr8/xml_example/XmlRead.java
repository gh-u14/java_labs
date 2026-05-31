package lr8.xml_example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XmlRead {

    private static final String FILE_PATH = "src/lr8/xml_example/films.xml";

    public static void main(String[] args) throws Exception {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("Файл не найден: " + FILE_PATH);
            return;
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);

        Element root = doc.getDocumentElement();
        System.out.println("Корневой элемент: " + root.getNodeName());

        NodeList films = doc.getElementsByTagName("film");
        for (int i = 0; i < films.getLength(); i++) {
            Node node = films.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            Element film = (Element) node;
            String title = film.getElementsByTagName("title").item(0).getTextContent();
            String director = film.getElementsByTagName("director").item(0).getTextContent();
            String year = film.getElementsByTagName("year").item(0).getTextContent();

            System.out.println("\nФильм:");
            System.out.println("  Название: " + title);
            System.out.println("  Режиссёр: " + director);
            System.out.println("  Год: " + year);
        }
    }
}
