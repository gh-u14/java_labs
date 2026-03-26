package lr3;

public class Task1 {
    private static int depth = 0;

    public static void main(String[] args) {
        System.out.println("=== Пример 1 ===");
        example1(1);

        System.out.println("\n=== Пример 2 ===");
        example2(1);

        System.out.println("\n=== Пример 3 ===");
        example3(1);

        System.out.println("\n=== Пример 4 ===");
        System.out.println("fact(5) = " + factorial(5));

        System.out.println("\n=== Пример 5 ===");
        int n = 6;
        System.out.println("fib(" + n + ") = " + fibonacci(n));
        System.out.println("Дерево рекурсивных вызовов для fib(" + n + "):");
        printFibonacciTree(n, "");
    }

    private static void example1(int x) {
        System.out.println("x=" + x);
        if ((2 * x + 1) < 20) {
            example1(2 * x + 1);
        }
    }

    private static void example2(int x) {
        if ((2 * x + 1) < 20) {
            example2(2 * x + 1);
        }
        System.out.println("x=" + x);
    }

    private static void example3(int x) {
        space(depth);
        System.out.println(x + " -> ");
        depth++;
        if ((2 * x + 1) < 20) {
            example3(2 * x + 1);
        }
        depth--;
        space(depth);
        System.out.println(x + " <-");
    }

    private static void space(int step) {
        for (int i = 0; i < step; i++) {
            System.out.print(" ");
        }
    }

    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return factorial(n - 1) * n;
    }

    private static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    private static void printFibonacciTree(int n, String indent) {
        System.out.println(indent + "fib(" + n + ")");
        if (n <= 1) {
            return;
        }
        printFibonacciTree(n - 2, indent + "  ");
        printFibonacciTree(n - 1, indent + "  ");
    }
}
