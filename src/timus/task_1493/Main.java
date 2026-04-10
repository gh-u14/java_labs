package timus.task_1493;

import java.util.Scanner;

public class Main {

    public static boolean isLucky(String ticket) {
        int sum1 = 0, sum2 = 0;

        for (int i = 0; i < 3; i++) {
            sum1 += ticket.charAt(i) - '0';
        }
        for (int i = 3; i < 6; i++) {
            sum2 += ticket.charAt(i) - '0';
        }

        return sum1 == sum2;
    }

    public static String format(int num) {
        return String.format("%06d", num);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ticket = scanner.nextLine();

        int num = Integer.parseInt(ticket);

        boolean ok = false;

        // проверяем предыдущий
        if (num > 0) {
            if (isLucky(format(num - 1))) {
                ok = true;
            }
        }

        // проверяем следующий
        if (num < 999999) {
            if (isLucky(format(num + 1))) {
                ok = true;
            }
        }

        System.out.println(ok ? "Yes" : "No");
    }
}