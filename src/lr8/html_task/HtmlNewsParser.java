package lr8.html_task;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class HtmlNewsParser {

    private static final String[] URLS = {
            "https://habr.com/ru/feed/"
    };
    private static final String OUTPUT_PATH = "src/lr8/html_task/news_output.txt";
    private static final int MAX_ATTEMPTS = 3;
    private static final long RETRY_DELAY_MS = 2000;

    public static void main(String[] args) {
        new java.io.File("src/lr8/html_task").mkdirs();

        Document doc = loadWithRetry();
        if (doc == null) {
            System.exit(1);
        }

        List<String> lines = parseNews(doc);
        if (lines.isEmpty()) {
            System.out.println("Новости не найдены на странице.");
            return;
        }

        for (String line : lines) {
            System.out.println(line);
        }

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(OUTPUT_PATH, StandardCharsets.UTF_8))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("\nДанные сохранены в " + OUTPUT_PATH);
        } catch (Exception e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    private static Document loadWithRetry() {
        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            for (String url : URLS) {
                try {
                    Document doc = Jsoup.connect(url)
                            .userAgent("Mozilla/5.0")
                            .timeout(10_000)
                            .get();
                    System.out.println("Страница загружена: " + url);
                    return doc;
                } catch (Exception e) {
                    System.out.println("Ошибка (" + url + "), попытка " + attempt
                            + ": " + e.getMessage());
                }
            }
            if (attempt < MAX_ATTEMPTS) {
                try {
                    Thread.sleep(RETRY_DELAY_MS);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    return null;
                }
            }
        }
        System.out.println("Не удалось загрузить страницу после " + MAX_ATTEMPTS + " попыток.");
        return null;
    }

    private static List<String> parseNews(Document doc) {
        List<String> result = new ArrayList<>();

        // Классическая разметка fat.urfu.ru (новости)
        Elements newsItems = doc.select(".news-item, .news_list li, .newsblock .item");
        for (Element item : newsItems) {
            String title = item.select(".title, .news-title, h2, h3, a").text().trim();
            String date = item.select(".date, .news-date, time, .data").text().trim();
            if (!title.isEmpty()) {
                result.add(formatLine(title, date));
            }
        }
        if (!result.isEmpty()) {
            return result;
        }

        // Таблица/список ссылок на новости
        Elements newsLinks = doc.select("a[href*=news], a[href*=News]");
        for (Element link : newsLinks) {
            String title = link.text().trim();
            if (title.length() > 15) {
                result.add(formatLine(title, ""));
            }
        }
        if (!result.isEmpty()) {
            return result;
        }

        // Запасной разбор: блоки с заголовком section_header (актуально для текущей страницы)
        Elements sections = doc.select("div.section_header");
        for (Element section : sections) {
            String title = section.text().trim();
            Element next = section.nextElementSibling();
            String date = "";
            if (next != null) {
                date = next.select("p, span").text().trim();
                if (date.length() > 80) {
                    date = date.substring(0, 80) + "...";
                }
            }
            if (!title.isEmpty()) {
                result.add(formatLine(title, date.isEmpty() ? "—" : date));
            }
        }

        return result;
    }

    private static String formatLine(String title, String date) {
        return "Тема: " + title + " | Дата: " + (date == null || date.isEmpty() ? "—" : date);
    }
}
