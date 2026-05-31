package lr8.html_example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlLinksParser {

    private static final String URL = "https://itlearn.ru/first-steps";

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect(URL)
                    .userAgent("Mozilla/5.0")
                    .timeout(10_000)
                    .get();

            Elements links = doc.select("a[href]");
            System.out.println("Ссылки на странице " + URL + ":\n");

            for (Element link : links) {
                String absUrl = link.absUrl("href");
                if (!absUrl.isEmpty()) {
                    System.out.println(absUrl);
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка при загрузке страницы: " + e.getMessage());
        }
    }
}
