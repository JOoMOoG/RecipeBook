package org.joomoog.repository;

import org.joomoog.repository.daos.RecipeDao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Repository {

    private RecipeDao recipeDao;

    public Repository() {
        this.recipeDao = new RecipeDao();
    }

    public void createDatabase(){

        String localAppData = System.getenv("LOCALAPPDATA");
        Path appFolder = Paths.get(localAppData, "RecipeBook");
        String databaseUrl = "jdbc:sqlite:" + appFolder + "\\recipeBook.db";
        try {
            Files.createDirectories(appFolder);
            System.out.println("Creating database at " + databaseUrl);
            DriverManager.getConnection(databaseUrl);
        } catch (IOException e) {
            System.out.println("Error creating database");
        } catch (SQLException e) {
            System.out.println("Error creating database");
        }
    }

}
