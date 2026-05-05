package timus.task_1654;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int len = stack.length();

            if (len > 0 && stack.charAt(len - 1) == ch) {
                // нашли пару → удаляем
                stack.deleteCharAt(len - 1);
            } else {
                stack.append(ch);
            }
        }

        System.out.println(stack.toString());
    }
}