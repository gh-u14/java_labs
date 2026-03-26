package lr3;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int value = scanner.nextInt();

        if (value < 0) {
            System.out.print("Двоичное представление: -");
            printBinaryRecursive(-value);
            System.out.println();
        } else {
            System.out.print("Двоичное представление: ");
            printBinaryRecursive(value);
            System.out.println();
        }
    }

    private static void printBinaryRecursive(int value) {
        if (value < 2) {
            System.out.print(value);
            return;
        }
        printBinaryRecursive(value / 2);
        System.out.print(value % 2);
    }
}
