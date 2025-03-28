package org.example.models;

import org.example.enums.RecipeCategory;

public class Recipe {
    private int id;
    private String name;
    private int portions;
    private RecipeCategory category;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPortions() {
        return portions;
    }

    public RecipeCategory getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPortions(int portions) {
        this.portions = portions;
    }

    public void setCategory(RecipeCategory category) {
        this.category = category;
    }
}
