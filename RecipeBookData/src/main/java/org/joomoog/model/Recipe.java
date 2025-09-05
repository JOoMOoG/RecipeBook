package org.joomoog.model;

import org.joomoog.model.enums.Protein;

public class Recipe {
    private final int id;
    private final String name;
    private final Protein protein;

    public Recipe(int id, String name, Protein protein) {
        this.id = id;
        this.name = name;
        this.protein = protein;
    }

    @Override
    public String toString() {
        return "Recipe {id: " + id + ", name: " + name + ", protein: " + protein + "}";
    }
}
