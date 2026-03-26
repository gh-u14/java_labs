package lr3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] data = new int[size];

        System.out.println("Введите элементы массива:");
        inputRecursive(data, 0, scanner);

        System.out.println("Введенный массив:");
        outputRecursive(data, 0);
        System.out.println();
    }

    private static void inputRecursive(int[] arr, int index, Scanner scanner) {
        if (index >= arr.length) {
            return;
        }
        System.out.print("arr[" + index + "] = ");
        arr[index] = scanner.nextInt();
        inputRecursive(arr, index + 1, scanner);
    }

    private static void outputRecursive(int[] arr, int index) {
        if (index >= arr.length) {
            return;
        }
        System.out.print(arr[index] + " ");
        outputRecursive(arr, index + 1);
    }
}
