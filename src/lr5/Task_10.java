package lr5;

import java.util.List;
import java.util.stream.Collectors;

public class Task_10 {
    public static void main(String[] args) {
        List<String> strings = List.of("Строки", "с123", "без", "цифр", "цифрами!");

        System.out.println("Исходный список: " + strings);
        System.out.println("Результат: " + filterAlphabeticStrings(strings));
    }

    public static List<String> filterAlphabeticStrings(List<String> list) {
        return list.stream()
                .filter(s -> s.matches("[\\p{L}]+"))
                .collect(Collectors.toList());
    }
}
