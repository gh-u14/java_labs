package lr5;

import java.util.List;
import java.util.stream.Collectors;

public class Task_8 {
    public static void main(String[] args) {
        List<String> strings = List.of("Строки", "длиннее", "заданного", "значения");
        int minLength = 6;

        System.out.println("Исходный список: " + strings);
        System.out.println("Минимальная длина: " + minLength);
        System.out.println("Результат: " + filterByMinLength(strings, minLength));
    }

    public static List<String> filterByMinLength(List<String> list, int minLength) {
        return list.stream()
                .filter(s -> s.length() > minLength)
                .collect(Collectors.toList());
    }
}
