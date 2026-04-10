package lr4;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Task2MatrixColumn {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean success = false;

        try {
            System.out.print("Число строк: ");
            int rows = scanner.nextInt();
            System.out.print("Число столбцов: ");
            int cols = scanner.nextInt();
            if (rows <= 0 || cols <= 0) {
                throw new IllegalArgumentException("Размеры матрицы должны быть положительными.");
            }

            int[][] matrix = new int[rows][cols];
            System.out.println("Введите матрицу " + rows + "x" + cols + " (по строкам):");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            System.out.print("Номер столбца (0 .. " + (cols - 1) + "): ");
            int col = scanner.nextInt();
            if (col < 0 || col >= cols) {
                throw new ArrayIndexOutOfBoundsException("Нет столбца с номером " + col);
            }

            System.out.println("Столбец " + col + ":");
            for (int i = 0; i < rows; i++) {
                System.out.println(matrix[i][col]);
            }
            success = true;

        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: ожидалось целое число. " + e);
            scanner.nextLine();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка индекса: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("Недостаточно данных: " + e.getMessage());
        } finally {
            System.out.println("Блок finally: операции с матрицей завершены. Успех: " + success);
            scanner.close();
        }
    }
}
