package timus.task_1110;

import java.util.*;

public class Main {

    static int powmod(int x, int n, int mod) {
        long result = 1;
        long base = x % mod;

        while (n > 0) {
            if ((n & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            n >>= 1;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int Y = sc.nextInt();

        boolean found = false;

        for (int x = 0; x < M; x++) {
            if (powmod(x, N, M) == Y) {
                System.out.print(x + " ");
                found = true;
            }
        }

        if (!found) {
            System.out.println(-1);
        }
    }
}