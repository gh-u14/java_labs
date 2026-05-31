package lr8.excel_task;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;

public class ExcelCreate {

    private static final String FILE_PATH = "src/lr8/excel_task/films.xlsx";
    private static final String SHEET_NAME = "Фильмы";

    public static void main(String[] args) throws Exception {
        new File("src/lr8/excel_task").mkdirs();

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet(SHEET_NAME);

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Название");
            header.createCell(1).setCellValue("Режиссёр");
            header.createCell(2).setCellValue("Год");

            String[][] data = {
                    {"Матрица", "Лана и Лилли Вачовски", "1999"},
                    {"Начало", "Кристофер Нолан", "2010"}
            };

            for (int i = 0; i < data.length; i++) {
                Row row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(data[i][0]);
                row.createCell(1).setCellValue(data[i][1]);
                row.createCell(2).setCellValue(data[i][2]);
            }

            for (int c = 0; c < 3; c++) {
                sheet.autoSizeColumn(c);
            }

            try (FileOutputStream out = new FileOutputStream(FILE_PATH)) {
                workbook.write(out);
            }
        }

        System.out.println("Данные успешно записаны в " + FILE_PATH);
    }
}
