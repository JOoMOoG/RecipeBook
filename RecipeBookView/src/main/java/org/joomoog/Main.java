package org.joomoog;

import org.joomoog.models.Recipe;
import org.joomoog.readers.ExcelReader;

public class Main {
    public static void main(String[] args) {
        ExcelReader reader = new ExcelReader();
        reader.read();
    }
}