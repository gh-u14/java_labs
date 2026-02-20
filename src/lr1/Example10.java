package lr1;

import java.util.Scanner;

public class Example10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите год рождения: ");
        int birthYear = in.nextInt();

        int currentYear = 2026;
        int age = currentYear - birthYear;

        System.out.println("Ваш возраст: " + age);
        in.close();
    }
}
