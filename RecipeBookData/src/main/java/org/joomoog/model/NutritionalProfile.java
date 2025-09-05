package org.joomoog.model;

import org.joomoog.model.enums.Measurement;

public class NutritionalProfile {
    private int id;
    private float fat;
    private float protein;
    private float carbs;
    private Measurement measurement;
    private float quantity;

    public void setId(int id) {
        this.id = id;
    }
    public void setFat(float fat) {
        this.fat = fat;
    }
    public void setProtein(float protein) {
        this.protein = protein;
    }
    public void setCarbs(float carbs) {
        this.carbs = carbs;
    }
    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }
    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "NutritionalProfile{" +
                "id:" + id +
                ", fat:" + fat +
                ", protein:" + protein +
                ", carbs:" + carbs +
                ", measurement:" + measurement +
                ", quantity:" + quantity +
                '}';
    }
}
