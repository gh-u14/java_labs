package lr8.json_task;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Scanner;

public class JsonFilmsApp {

    private static final String FILE_PATH = "src/lr8/json_task/films.json";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Список фильмов (JSON) ===");
            System.out.println("1 — показать все фильмы");
            System.out.println("2 — поиск по режиссёру");
            System.out.println("3 — добавить фильм");
            System.out.println("4 — удалить фильм по названию");
            System.out.println("0 — выход");
            System.out.print("Выбор: ");

            String choice = scanner.nextLine().trim();
            JSONObject root = loadRoot();
            JSONArray films = (JSONArray) root.get("films");

            switch (choice) {
                case "1" -> printAll(films);
                case "2" -> searchByDirector(scanner, films);
                case "3" -> {
                    addFilm(scanner, films);
                    saveRoot(root);
                }
                case "4" -> {
                    if (deleteByTitle(scanner, films)) {
                        saveRoot(root);
                    }
                }
                case "0" -> {
                    scanner.close();
                    return;
                }
                default -> System.out.println("Неизвестная команда.");
            }
        }
    }

    private static JSONObject loadRoot() throws Exception {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(FILE_PATH)) {
            return (JSONObject) parser.parse(reader);
        }
    }

    private static void saveRoot(JSONObject root) throws Exception {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(root.toJSONString());
        }
        System.out.println("Файл сохранён.");
    }

    private static void printFilm(JSONObject film) {
        System.out.println("  Название: " + film.get("title"));
        System.out.println("  Режиссёр: " + film.get("director"));
        System.out.println("  Год: " + film.get("year"));
    }

    private static void printAll(JSONArray films) {
        if (films.isEmpty()) {
            System.out.println("Список фильмов пуст.");
            return;
        }
        for (Object item : films) {
            System.out.println();
            printFilm((JSONObject) item);
        }
    }

    private static void searchByDirector(Scanner scanner, JSONArray films) {
        System.out.print("Режиссёр: ");
        String director = scanner.nextLine().trim();

        for (Object item : films) {
            if (!(item instanceof JSONObject film)) {
                continue;
            }
            if (director.equalsIgnoreCase(String.valueOf(film.get("director")))) {
                System.out.println("\nНайден фильм:");
                printFilm(film);
            }
        }
    }

    private static void addFilm(Scanner scanner, JSONArray films) {
        System.out.print("Название: ");
        String title = scanner.nextLine().trim();
        System.out.print("Режиссёр: ");
        String director = scanner.nextLine().trim();
        System.out.print("Год: ");
        String year = scanner.nextLine().trim();

        JSONObject newFilm = new JSONObject();
        newFilm.put("title", title);
        newFilm.put("director", director);
        newFilm.put("year", year);
        films.add(newFilm);
        System.out.println("Фильм добавлен.");
    }

    private static boolean deleteByTitle(Scanner scanner, JSONArray films) {
        System.out.print("Название для удаления: ");
        String title = scanner.nextLine().trim();

        Iterator iterator = films.iterator();
        boolean removed = false;
        while (iterator.hasNext()) {
            JSONObject film = (JSONObject) iterator.next();
            if (title.equalsIgnoreCase(String.valueOf(film.get("title")))) {
                iterator.remove();
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("Фильм удалён.");
        } else {
            System.out.println("Фильм не найден.");
        }
        return removed;
    }
}
