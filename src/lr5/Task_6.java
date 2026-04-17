package lr5;

import java.util.List;
import java.util.stream.Collectors;

public class Task_6 {
    public static void main(String[] args) {
        List<String> strings = List.of("Строки", "для", "поиска", "подстрок");
        String substring = "тро";

        System.out.println("Исходный список: " + strings);
        System.out.println("Подстрока: " + substring);
        System.out.println("Результат: " + filterBySubstring(strings, substring));
    }

    public static List<String> filterBySubstring(List<String> list, String substring) {
        return list.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }
}
