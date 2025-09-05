package org.joomoog.model;


public class RecipeStep {
    private int id;
    private int recipeId;
    private String description;

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "RecipeStep{" +
                "id=" + id +
                ", recipeId=" + recipeId +
                ", description='" + description + '\'' +
                '}';
    }
}
