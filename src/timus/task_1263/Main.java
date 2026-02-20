package timus.task_1263;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] votes = new int[N];

        for (int i = 0; i < M; i++) {
            int candidate = sc.nextInt();
            votes[candidate - 1]++;
        }

        for (int i = 0; i < N; i++) {
            double percent = (double) votes[i] * 100 / M;
            System.out.printf("%.2f%%\n", percent);
        }
    }
}