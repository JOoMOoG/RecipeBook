package org.example.databaseManager;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.example.models.Ingredient;
import org.example.models.Recipe;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataFileManager {
    public static void importExcel(String filePath) {
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = WorkbookFactory.create(fis)) {

            for (Sheet sheet : workbook) {
                String sheetName = sheet.getSheetName().toLowerCase();

                switch (sheetName) {
                    case "ingredientes":
                        List<Ingredient> ingredients = processIngredients(sheet);
                        System.out.println("Ingredientes carregados: " + ingredients.size());
                        break;

                    case "receitas":
                        List<Receita> receitas = processarReceitas(sheet);
                        System.out.println("Receitas carregadas: " + receitas.size());
                        break;

                    case "receitas_calorias":
                        List<IngredientePorReceita> ingredientesPorReceita = processarIngredientesPorReceita(sheet);
                        System.out.println("Ingredientes por receita carregados: " + ingredientesPorReceita.size());
                        break;

                    case "passos":
                        List<PassoReceita> passos = processarPassosReceita(sheet);
                        System.out.println("Passos carregados: " + passos.size());
                        break;

                    default:
                        System.out.println("Folha ignorada: " + sheetName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static List<Ingredient> processIngredients(Sheet sheet) {
        List<Ingredient> ingredients = new ArrayList<>();
        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue;
            Ingredient ingredient = new Ingredient();
            ingredient.setId(Integer.parseInt(row.getCell(0).getStringCellValue()));
            ingredient.setFats();
            ingredients.add(new Ingredient(
                    row.getCell(0).getStringCellValue(),
                    row.getCell(1).getStringCellValue()
            ));
        }
        return ingredientes;
    }
}
