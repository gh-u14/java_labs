package lr5;

import java.util.List;
import java.util.stream.Collectors;

public class Task_7 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 4, 6, 7, 9, 10, 12, 15);
        int divisor = 3;

        System.out.println("Исходный список: " + numbers);
        System.out.println("Делитель: " + divisor);
        System.out.println("Результат: " + filterDivisibleBy(numbers, divisor));
    }

    public static List<Integer> filterDivisibleBy(List<Integer> list, int divisor) {
        return list.stream()
                .filter(x -> x % divisor == 0)
                .collect(Collectors.toList());
    }
}
