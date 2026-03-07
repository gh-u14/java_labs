package lr2;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст для шифрования");
        String text = scanner.nextLine();

        System.out.println("Введите ключ");
        int key = scanner.nextInt();
        scanner.nextLine();

        // используем метод из внутреннего класса Encrypt
        String encrypted = Encrypt.getEncryptString(text, key);
        System.out.println("Текст после преобразования: " + encrypted);

        System.out.println("Выполнить обратное преобразование? (y/n)");
        String answer = scanner.nextLine().trim().toLowerCase();

        if ("y".equals(answer)) {
            String decrypted = Encrypt.getEncryptString(encrypted, -key);
            System.out.println("Текст после обратного преобразования: " + decrypted);
        } else if ("n".equals(answer)) {
            System.out.println("До свидания!");
        } else {
            System.out.println("Введите корректный ответ");
        }

        scanner.close();
    }
}

class Encrypt {

    public static String getEncryptString(String encryptString, int shift) {
        char[] chars = encryptString.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] + shift);
        }

        return new String(chars);
    }
}