package org.joomoog.readers;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;

public class ExcelReader {
    public void read() {
        InputStream is = getClass().getResourceAsStream("/receitas.xlsx");
        if (is == null) {
            System.out.println("Ficheiro não encontrado");
            return;
        }
        try (InputStream input = is; XSSFWorkbook book = new XSSFWorkbook(input)) {
            XSSFSheet sheet = book.getSheet("recipes");
            System.out.println(sheet.getRow(0).getCell(0));
        } catch (Exception e) {
            System.out.println("deu erro");
        }
    }
}
