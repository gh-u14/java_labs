package lr8.json_example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;

public class JsonCreate {

    private static final String FILE_PATH = "src/lr8/json_example/films.json";

    public static void main(String[] args) throws Exception {
        new java.io.File("src/lr8/json_example").mkdirs();

        JSONObject root = new JSONObject();
        JSONArray films = new JSONArray();

        films.add(createFilm("Матрица", "Лана и Лилли Вачовски", "1999"));
        films.add(createFilm("Начало", "Кристофер Нолан", "2010"));

        root.put("films", films);

        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(root.toJSONString());
        }

        System.out.println("JSON-файл успешно создан: " + FILE_PATH);
    }

    private static JSONObject createFilm(String title, String director, String year) {
        JSONObject film = new JSONObject();
        film.put("title", title);
        film.put("director", director);
        film.put("year", year);
        return film;
    }
}
