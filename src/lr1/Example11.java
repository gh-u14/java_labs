package lr1;

import java.util.Scanner;

public class Example11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите имя: ");
        String name = in.nextLine();

        System.out.println("Введите год рождения: ");
        int birthYear = in.nextInt();

        int currentYear = 2026;
        int age = currentYear - birthYear;

        System.out.println(name + ", ваш возраст: " + age);
        in.close();
    }
}
