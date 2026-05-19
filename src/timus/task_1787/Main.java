package timus.task_1787;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        int n = scanner.nextInt();

        int queue = 0;

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();

            queue += a;      // приехали машины
            queue -= k;      // успели повернуть

            if (queue < 0) {
                queue = 0;   // пробка не может быть отрицательной
            }
        }

        System.out.println(queue);
    }
}