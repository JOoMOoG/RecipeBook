package org.example.daos;

import org.example.models.Recipe;

import java.util.List;

public interface RecipeDao {
    void insert(Recipe recipe);
    Recipe findById(int id);
    List<Recipe> findAll();
    void update(Recipe recipe);
    void delete(int id);
}
