package lr7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task3_example8 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new FileReader("src/lr7/task3_example8/input.txt"));

        int lineCount = 0;
        while (reader.readLine() != null) {
            lineCount++;
        }
        reader.close();

        System.out.println("Количество строк в файле: " + lineCount);
    }
}
