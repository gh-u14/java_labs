package lr8.excel_task;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelRead {

    private static final String FILE_PATH = "src/lr8/excel_task/films.xlsx";
    private static final String SHEET_NAME = "Фильмы";

    public static void main(String[] args) {
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            System.err.println("Ошибка: файл не найден — " + FILE_PATH);
            System.err.println("Сначала запустите ExcelCreate или скопируйте films.xlsx в excel_task.");
            System.exit(1);
        }

        if (!file.getName().toLowerCase().endsWith(".xlsx")) {
            System.err.println("Ошибка: ожидается формат .xlsx");
            System.err.println("Исправьте файл и перезапустите программу.");
            System.exit(1);
        }

        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(SHEET_NAME);
            if (sheet == null) {
                System.err.println("Ошибка: лист «" + SHEET_NAME + "» не найден в файле.");
                System.err.println("Проверьте имя листа и перезапустите программу.");
                System.exit(1);
            }

            System.out.println("Содержимое листа «" + SHEET_NAME + "»:\n");

            for (Row row : sheet) {
                if (row == null) {
                    continue;
                }
                StringBuilder line = new StringBuilder();
                for (int c = 0; c < row.getLastCellNum(); c++) {
                    Cell cell = row.getCell(c);
                    if (c > 0) {
                        line.append(" | ");
                    }
                    line.append(cell == null ? "" : cell.toString());
                }
                System.out.println(line);
            }

        } catch (org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException e) {
            System.err.println("Ошибка: файл повреждён или не является корректным XLSX.");
            System.err.println("Запустите ExcelCreate и перезапустите программу.");
            System.exit(1);
        } catch (Exception e) {
            System.err.println("Ошибка чтения Excel: " + e.getMessage());
            System.err.println("Исправьте файл и перезапустите программу.");
            System.exit(1);
        }
    }
}
