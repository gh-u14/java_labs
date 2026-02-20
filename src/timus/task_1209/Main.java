package timus.task_1209;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            long K = sc.nextLong();

            long D = 1 + 8 * (K - 1);
            long sqrtD = (long)Math.sqrt(D);

            if (sqrtD * sqrtD == D) {
                sb.append("1");
            } else {
                sb.append("0");
            }

            if (i != N - 1) sb.append(" ");
        }

        System.out.println(sb.toString());
    }
}