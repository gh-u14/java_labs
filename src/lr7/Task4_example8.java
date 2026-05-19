package lr7;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task4_example8 {

    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("src/lr7/task4_example8/input.txt");
        FileWriter writer = new FileWriter("src/lr7/task4_example8/output.txt");

        int c;
        while ((c = reader.read()) != -1) {
            writer.write(c);
        }

        reader.close();
        writer.close();

        System.out.println("Файл скопирован успешно!");
    }
}