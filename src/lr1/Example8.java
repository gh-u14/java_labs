package lr1;

import java.util.Scanner;

public class Example8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите название текущего дня недели: ");
        String dayOfWeek = in.nextLine();

        System.out.println("Введите название месяца: ");
        String month = in.nextLine();

        System.out.println("Введите дату (номер дня в месяце): ");
        int date = in.nextInt();

        System.out.println("Сегодня: " + dayOfWeek + ", " + date + ", " + month);
        in.close();
    }
}
