package timus.task_1607;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(); // цена Пети
        int b = sc.nextInt(); // шаг Пети
        int c = sc.nextInt(); // цена таксиста
        int d = sc.nextInt(); // шаг таксиста

        while (true) {
            if (a >= c) {
                System.out.println(a);
                break;
            }

            a += b;
            c -= d;
        }
    }
}