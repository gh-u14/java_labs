package lr1;

import java.util.Scanner;

public class Example14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите число: ");
        int n = in.nextInt();

        int prev = n - 1;
        int next = n + 1;
        int sumOfThree = prev + n + next;
        int fourth = sumOfThree * sumOfThree;

        System.out.println(prev + ", " + n + ", " + next + ", " + fourth);
        in.close();
    }
}
