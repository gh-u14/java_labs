package lr4;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Task2AveragePositive {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean success = false;

        try {
            System.out.print("Введите количество элементов n: ");
            int n = scanner.nextInt();
            if (n <= 0) {
                throw new IllegalArgumentException("Количество элементов должно быть положительным.");
            }

            int[] a = new int[n];
            System.out.println("Введите " + n + " целых чисел:");
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            long sum = 0;
            int count = 0;
            for (int value : a) {
                if (value > 0) {
                    sum += value;
                    count++;
                }
            }
            if (count == 0) {
                throw new IllegalArgumentException("Положительные элементы отсутствуют.");
            }

            double avg = (double) sum / count;
            System.out.println("Среднее среди положительных: " + avg);
            success = true;

        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: ожидалось целое число (введена строка или несовместимый тип). "
                    + e.getMessage());
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("Недостаточно данных во вводе: " + e.getMessage());
        } finally {
            System.out.println("Блок finally: завершение работы со вводом. Успех: " + success);
            scanner.close();
        }
    }
}
