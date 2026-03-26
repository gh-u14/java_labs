package lr3;

import java.util.HashMap;
import java.util.Map;

public class Task5 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "orange");
        map.put(3, "banana");
        map.put(4, "cat");
        map.put(5, "strawberry");
        map.put(6, "grape");
        map.put(7, "pineapple");
        map.put(8, "plum");
        map.put(9, "watermelon");

        System.out.println("Строки, у которых ключ > 5:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                System.out.println(entry.getValue());
            }
        }

        System.out.println("\nСтроки с ключом = 0: ");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() == 0) {
                System.out.print(entry.getValue());
            }
        }
        System.out.println();

        long product = 1L;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > 5) {
                product *= entry.getKey();
            }
        }

        System.out.println("\nПроизведение ключей (длина строки > 5): " + product);
    }
}
