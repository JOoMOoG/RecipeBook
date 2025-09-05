package org.joomoog.model;

import org.joomoog.model.enums.Measurement;

public class RecipeIngredient {
    private int recipeId;
    private int ingredientId;
    private float quantity;
    private Measurement measurement;

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }
    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }
    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }
    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    @Override
    public String toString() {
        return "RecipeIngredient {" +
                "recipeId:" + recipeId +
                ", ingredientId:" + ingredientId +
                ", quantity:" + quantity +
                ", measurement:" + measurement +
                '}';
    }
}
