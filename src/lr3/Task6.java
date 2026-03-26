package lr3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите N (количество людей): ");
        int n = scanner.nextInt();

        long startArray = System.nanoTime();
        int winnerArray = byArrayList(n);
        long arrayTime = System.nanoTime() - startArray;

        long startLinked = System.nanoTime();
        int winnerLinked = byLinkedList(n);
        long linkedTime = System.nanoTime() - startLinked;

        System.out.println("Победитель (ArrayList): " + winnerArray);
        System.out.println("Победитель (LinkedList): " + winnerLinked);
        System.out.println("Время ArrayList: " + arrayTime + " нс");
        System.out.println("Время LinkedList: " + linkedTime + " нс");

        if (arrayTime < linkedTime) {
            System.out.println("Быстрее сработал ArrayList в данном запуске");
        } else if (arrayTime > linkedTime) {
            System.out.println("Быстрее сработал LinkedList в данном запуске");
        } else {
            System.out.println("Время оказалось одинаковым в данном запуске");
        }

    }

    private static int byArrayList(int n) {
        List<Integer> people = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }

        int index = 0;
        while (people.size() > 1) {
            index = (index + 1) % people.size();
            people.remove(index);
        }
        return people.get(0);
    }

    private static int byLinkedList(int n) {
        List<Integer> people = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }

        int index = 0;
        while (people.size() > 1) {
            index = (index + 1) % people.size();
            people.remove(index);
        }
        return people.get(0);
    }
}
