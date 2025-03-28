package org.example.services;

import org.example.databaseManager.DataFileManager;
import org.example.models.Recipe;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class DatabaseService {
    private final Connection connection;
    private DataFileManager dataFileManager = new DataFileManager();

    public DatabaseService(Connection connection) {
        this.connection = connection;
    }

    public boolean isNewDatabase() {
        String sql = "SELECT name FROM sqlite_master WHERE type='table' AND name NOT LIKE 'sqlite_%'";
        try (
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery())
        {
            if (resultSet.next()) {
                System.out.println("Database is not new");
                return false;
            }
            System.out.println("Database is new");
            return true;
        } catch (SQLException e) {
            System.out.println("EError in metthod isNewDatabase");
        }
        System.out.println("error");
        return false;
    }

    private boolean isDatabaseEmpty() throws SQLException {
        String sql = "SELECT name FROM sqlite_master WHERE type='table' AND name NOT LIKE 'sqlite_%'";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                System.out.println("Database is NOT empty");
                return false;
            }
            System.out.println("Database is empty");
            return true;
        }
    }


    public void setupDatabase(String fileName) {

       try {
           System.out.println("Database init()");
           createTables();
           System.out.println("Database created");
           populateTables(fileName);
       } catch (Exception e) {
           System.out.println("Error in setupDatabase");
       }

    }

    private void createTables() {
        String[] tables = getTables();

        // Começa uma transação
        try {
            connection.setAutoCommit(false);  // Desabilita o autocommit para começar a transação

            for (String table : tables) {
                try (Statement stmt = connection.createStatement()) {
                    stmt.executeUpdate(table);  // Executa cada criação de tabela
                    System.out.println("Table " + table + "created successfully.");
                } catch (SQLException e) {
                    // Se algum erro ocorrer, faz rollback e termina a execução
                    connection.rollback();
                    System.out.println("Error creating tables: " + e.getMessage());
                    return;
                }
            }

            // Se tudo correr bem, faz commit
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Transaction failed: " + e.getMessage());
            try {
                connection.rollback();  // Faz rollback em caso de erro em toda a transação
            } catch (SQLException ex) {
                System.out.println("Error rolling back: " + ex.getMessage());
            }
        } finally {
            // Sempre garante que o autocommit é restaurado
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Error restoring autocommit: " + e.getMessage());
            }
        }
    }

    private static String[] getTables() {
        String sqlRecipes = "CREATE TABLE IF NOT EXISTS recipes (" +
                "id INTEGER PRIMARY KEY, " +
                "name TEXT NOT NULL, " +
                "portions INTEGER NOT NULL, " +
                "category TEXT NOT NULL);";

        String sqlIngredients = "CREATE TABLE IF NOT EXISTS ingredients (" +
                "id INTEGER PRIMARY KEY, " +
                "name TEXT NOT NULL, " +
                "category TEXT NOT NULL, " +
                "protein REAL NOT NULL, " +
                "fats REAL NOT NULL, " +
                "carbohydrates REAL NOT NULL, " +
                "sugars REAL NOT NULL, " +
                "sodium REAL NOT NULL);";

        String sqlRecipesAndIngredients = "CREATE TABLE IF NOT EXISTS recipe_ingredients (" +
                "recipe_id INTEGER NOT NULL, " +
                "ingredient_id INTEGER NOT NULL, " +
                "measure_unit TEXT NOT NULL, " +
                "quantity REAL NOT NULL, " +
                "FOREIGN KEY(recipe_id) REFERENCES recipes(id) ON DELETE CASCADE, " +
                "FOREIGN KEY(ingredient_id) REFERENCES ingredients(id), " +
                "PRIMARY KEY (recipe_id, ingredient_id));";

        String sqlRecipesSteps = "CREATE TABLE IF NOT EXISTS recipe_steps (" +
                "recipe_id INTEGER NOT NULL, " +
                "step_number INTEGER NOT NULL, " +
                "description TEXT NOT NULL, " +
                "FOREIGN KEY (recipe_id) REFERENCES recipes(id) ON DELETE CASCADE, " +
                "PRIMARY KEY (recipe_id, step_number), " +
                "UNIQUE (recipe_id, step_number));";

        return new String[]{sqlRecipes, sqlIngredients, sqlRecipesAndIngredients, sqlRecipesSteps};
    }
    private void populateTables(String fileName) {
        System.out.println("Populating from " + fileName);
        ArrayList<String[]> recipes = dataFileManager.readRecipes(fileName);
        for(String[] recipe: recipes){
            System.out.println(Arrays.toString(recipe));
        }

    }

}

