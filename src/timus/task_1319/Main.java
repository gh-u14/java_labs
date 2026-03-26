package timus.task_1319;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] a = new int[n][n];
        int num = 1;

        // начинаем с верхней строки (справа налево)
        for (int startCol = n - 1; startCol >= 0; startCol--) {
            int i = 0;
            int j = startCol;

            while (i < n && j < n) {
                a[i][j] = num++;
                i++;
                j++;
            }
        }

        // затем с первого столбца (со второй строки)
        for (int startRow = 1; startRow < n; startRow++) {
            int i = startRow;
            int j = 0;

            while (i < n && j < n) {
                a[i][j] = num++;
                i++;
                j++;
            }
        }

        // вывод
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}