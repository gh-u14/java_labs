package timus.task_1796;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] values = {10, 50, 100, 500, 1000, 5000};

        long sum = 0;
        int minBill = Integer.MAX_VALUE;

        // читаем количество купюр
        for (int i = 0; i < 6; i++) {
            int count = scanner.nextInt();

            if (count > 0) {
                minBill = Math.min(minBill, values[i]);
            }

            sum += (long) count * values[i];
        }

        int price = scanner.nextInt();

        ArrayList<Long> answers = new ArrayList<>();

        // количество билетов x:
        // sum - minBill < x * price <= sum
        long left = (sum - minBill) / price + 1;
        long right = sum / price;

        for (long x = left; x <= right; x++) {
            answers.add(x);
        }

        System.out.println(answers.size());

        for (long x : answers) {
            System.out.print(x + " ");
        }
    }
}