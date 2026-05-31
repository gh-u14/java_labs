package lr8.xml_task;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class XmlFilmsApp {

    private static final String FILE_PATH = "src/lr8/xml_task/films.xml";

    public static void main(String[] args) throws Exception {
        new File("src/lr8/xml_task").mkdirs();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Список фильмов (XML) ===");
            System.out.println("1 — показать все фильмы");
            System.out.println("2 — добавить фильм");
            System.out.println("3 — поиск по режиссёру или году");
            System.out.println("4 — удалить фильм по названию");
            System.out.println("0 — выход");
            System.out.print("Выбор: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> printAllFilms(loadDocument());
                case "2" -> addFilm(scanner);
                case "3" -> searchFilms(scanner);
                case "4" -> deleteFilm(scanner);
                case "0" -> {
                    scanner.close();
                    return;
                }
                default -> System.out.println("Неизвестная команда.");
            }
        }
    }

    private static Document loadDocument() throws Exception {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.newDocument();
            doc.appendChild(doc.createElement("cinema"));
            saveDocument(doc);
        }
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        return builder.parse(new File(FILE_PATH));
    }

    private static void saveDocument(Document doc) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.transform(new DOMSource(doc), new StreamResult(new File(FILE_PATH)));
    }

    private static List<Element> getFilmElements(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("film");
        return IntStream.range(0, nodeList.getLength())
                .mapToObj(nodeList::item)
                .filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
                .map(node -> (Element) node)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static String getChildText(Element parent, String tag) {
        return parent.getElementsByTagName(tag).item(0).getTextContent();
    }

    private static void printFilm(Element film) {
        System.out.println("  Название: " + getChildText(film, "title"));
        System.out.println("  Режиссёр: " + getChildText(film, "director"));
        System.out.println("  Год: " + getChildText(film, "year"));
    }

    private static void printAllFilms(Document doc) {
        List<Element> films = getFilmElements(doc);
        if (films.isEmpty()) {
            System.out.println("Список фильмов пуст.");
            return;
        }
        for (int i = 0; i < films.size(); i++) {
            System.out.println("\nФильм " + (i + 1) + ":");
            printFilm(films.get(i));
        }
    }

    private static void addFilm(Scanner scanner) throws Exception {
        Document doc = loadDocument();
        Element cinema = doc.getDocumentElement();

        System.out.print("Название: ");
        String title = scanner.nextLine().trim();
        System.out.print("Режиссёр: ");
        String director = scanner.nextLine().trim();
        System.out.print("Год: ");
        String year = scanner.nextLine().trim();

        Element film = doc.createElement("film");
        cinema.appendChild(film);

        Element titleEl = doc.createElement("title");
        titleEl.setTextContent(title);
        film.appendChild(titleEl);

        Element directorEl = doc.createElement("director");
        directorEl.setTextContent(director);
        film.appendChild(directorEl);

        Element yearEl = doc.createElement("year");
        yearEl.setTextContent(year);
        film.appendChild(yearEl);

        saveDocument(doc);
        System.out.println("Фильм добавлен.");
    }

    private static void searchFilms(Scanner scanner) throws Exception {
        Document doc = loadDocument();
        System.out.print("Режиссёр (Enter — пропустить): ");
        String directorQuery = scanner.nextLine().trim();
        System.out.print("Год (Enter — пропустить): ");
        String yearQuery = scanner.nextLine().trim();

        if (directorQuery.isEmpty() && yearQuery.isEmpty()) {
            System.out.println("Укажите режиссёра и/или год.");
            return;
        }

        List<Element> found = getFilmElements(doc).stream()
                .filter(film -> {
                    String director = getChildText(film, "director");
                    String year = getChildText(film, "year");
                    boolean matchDirector = directorQuery.isEmpty()
                            || director.equalsIgnoreCase(directorQuery);
                    boolean matchYear = yearQuery.isEmpty() || year.equals(yearQuery);
                    return matchDirector && matchYear;
                })
                .collect(Collectors.toList());

        if (found.isEmpty()) {
            System.out.println("Фильмы не найдены.");
            return;
        }
        for (Element film : found) {
            System.out.println();
            printFilm(film);
        }
    }

    private static void deleteFilm(Scanner scanner) throws Exception {
        Document doc = loadDocument();
        System.out.print("Название фильма для удаления: ");
        String title = scanner.nextLine().trim();

        List<Element> films = getFilmElements(doc);
        Element toRemove = films.stream()
                .filter(f -> getChildText(f, "title").equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);

        if (toRemove == null) {
            System.out.println("Фильм не найден.");
            return;
        }

        Node parent = toRemove.getParentNode();
        parent.removeChild(toRemove);
        saveDocument(doc);
        System.out.println("Фильм удалён.");
    }
}
