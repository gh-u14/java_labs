package lr5;

import java.util.List;
import java.util.stream.Collectors;

public class Task_9 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 3, 5, 7, 9, 11);
        int threshold = 6;

        System.out.println("Исходный список: " + numbers);
        System.out.println("Порог: " + threshold);
        System.out.println("Результат: " + filterGreaterThan(numbers, threshold));
    }

    public static List<Integer> filterGreaterThan(List<Integer> list, int threshold) {
        return list.stream()
                .filter(x -> x > threshold)
                .collect(Collectors.toList());
    }
}
