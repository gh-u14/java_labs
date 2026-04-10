package lr4;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Task2ByteArraySum {

    private static byte parseByteStrict(int value) {
        if (value < Byte.MIN_VALUE || value > Byte.MAX_VALUE) {
            throw new ArithmeticException("Значение " + value + " вне диапазона byte ["
                    + Byte.MIN_VALUE + " .. " + Byte.MAX_VALUE + "]");
        }
        return (byte) value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean success = false;

        try {
            System.out.print("Введите количество элементов: ");
            int n = scanner.nextInt();
            if (n <= 0) {
                throw new IllegalArgumentException("Размер массива должен быть положительным.");
            }

            byte[] arr = new byte[n];
            System.out.println("Введите " + n + " целых чисел в диапазоне byte:");
            for (int i = 0; i < n; i++) {
                if (!scanner.hasNextInt()) {
                    throw new InputMismatchException("Ожидалось целое число для элемента " + i);
                }
                int v = scanner.nextInt();
                arr[i] = parseByteStrict(v);
            }

            int sumAsInt = 0;
            for (byte b : arr) {
                sumAsInt += b;
            }
            if (sumAsInt < Byte.MIN_VALUE || sumAsInt > Byte.MAX_VALUE) {
                throw new ArithmeticException("Сумма выходит за границы типа byte: " + sumAsInt);
            }
            byte sum = (byte) sumAsInt;
            System.out.println("Сумма элементов (byte): " + sum);
            success = true;

        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода (строка вместо числа или неверный токен): " + e.getMessage());
            scanner.nextLine();
        } catch (ArithmeticException e) {
            System.out.println("Выход за границы byte: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("Недостаточно данных: " + e.getMessage());
        } finally {
            System.out.println("Блок finally: ввод завершён. Успех: " + success);
            scanner.close();
        }
    }
}
