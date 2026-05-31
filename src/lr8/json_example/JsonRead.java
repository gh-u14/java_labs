package lr8.json_example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonRead {

    private static final String FILE_PATH = "src/lr8/json_example/films.json";

    public static void main(String[] args) throws Exception {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(FILE_PATH)) {
            JSONObject root = (JSONObject) parser.parse(reader);
            System.out.println("Корневой ключ: films");

            JSONArray films = (JSONArray) root.get("films");
            for (Object item : films) {
                JSONObject film = (JSONObject) item;
                System.out.println("\nФильм:");
                System.out.println("  Название: " + film.get("title"));
                System.out.println("  Режиссёр: " + film.get("director"));
                System.out.println("  Год: " + film.get("year"));
            }
        }
    }
}
