package timus.task_1409;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int a = scanner.nextInt(); // Гарри
        int b = scanner.nextInt(); // Ларри
        
        System.out.println((b - 1) + " " + (a - 1));
    }
}