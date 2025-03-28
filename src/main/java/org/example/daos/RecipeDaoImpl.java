package org.example.daos;

import org.example.models.Recipe;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RecipeDaoImpl implements RecipeDao{
    private final Connection connection;


    public RecipeDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Recipe recipe) {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Recipe findById(int id) {
        return null;
    }

    @Override
    public List<Recipe> findAll() {
        return List.of();
    }

    @Override
    public void update(Recipe recipe) {

    }

    @Override
    public void delete(int id) {

    }
}
