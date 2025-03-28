package org.example.models;

public class Ingredient {
    private int id;
    private String name;
    private String category;
    private int proteins;
    private int fats;
    private int carbohydrates;
    private int sugars;
    private int sodium;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public void setSugars(int sugars) {
        this.sugars = sugars;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }
}
