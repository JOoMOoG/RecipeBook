package org.example.services;

import java.sql.*;

public class DatabaseService {
    private final Connection connection;

    public DatabaseService(Connection connection) {
        this.connection = connection;
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


    public boolean setupDatabase() throws SQLException {

        final boolean dataBaseEmpty = isDatabaseEmpty();
        if (dataBaseEmpty) {
            System.out.println("Database init()");
            createTables();
            return true;
        }
        return false;
    }

    private void createTables() {
        System.out.println("Creating tables");
        System.out.println("Creating table of recipes");

        String sql_recipes = "CREATE TABLE IF NOT EXISTS recipes (id INTEGER PRIMARY KEY, name TEXT, description TEXT)";
        String sql_ingredients = "CREATE TABLE IF NOT EXISTS recipes (id INTEGER PRIMARY KEY, name TEXT, description TEXT)";
        String sql_recipes_and_ingredients = "CREATE TABLE IF NOT EXISTS recipes (id INTEGER PRIMARY KEY, name TEXT, description TEXT)";

        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql_recipes);
            System.out.println("Table recipes created");
        } catch (SQLException e) {
            System.out.println("Error creating tables: " + e.getMessage());
        }
    }
}

