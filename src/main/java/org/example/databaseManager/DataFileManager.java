package org.example.databaseManager;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.example.models.Recipe;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class DataFileManager {

    public ArrayList<String[]> readRecipes(String fileName) {
        ArrayList<String[]> recipes = new ArrayList<String[]>();
        try (FileInputStream fis = new FileInputStream(new File(fileName));
             Workbook workbook = new HSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                String[] recipe = new String[2];
                for (int i = 0; i < row.getLastCellNum() ; i++) {
                    recipe[i] = row.getCell(i).getStringCellValue();
                }

                recipes.add(recipe);
            }
        } catch (IOException e) {
            System.out.println("Error reading  recipes from file " + fileName);
        }
        return recipes;
    }
}
