package timus.task_1349;

import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println(-1);
            return;
        }

        for (int a = 1; a <= 100; a++) {
            for (int b = 1; b <= 100; b++) {
                if (b == a) continue;

                for (int c = 1; c <= 100; c++) {
                    if (c == a || c == b) continue;

                    BigInteger A = BigInteger.valueOf(a).pow(n);
                    BigInteger B = BigInteger.valueOf(b).pow(n);
                    BigInteger C = BigInteger.valueOf(c).pow(n);

                    if (A.add(B).equals(C)) {
                        System.out.println(a + " " + b + " " + c);
                        return;
                    }
                }
            }
        }

        System.out.println(-1);
    }
}