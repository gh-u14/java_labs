package lr7;

import java.io.*;
import java.util.Scanner;

public class Task7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название файла: ");
        String fileName = scanner.nextLine().trim();

        System.out.print("Введите текст для записи: ");
        String text = scanner.nextLine();

        // Путь к папке src/lr7/task7
        String dirPath = "src/lr7/task7";
        File dir = new File(dirPath);

        // Создаём папку, если её нет
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Создаём файл внутри src/lr7/task7
        File file = new File(dir, fileName);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(text);

            System.out.println("\nТекст успешно записан в файл: " + file.getAbsolutePath());
            System.out.println("Количество записанных символов: " + text.length());

        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }
    }
}