package org.joomoog.model;

import org.joomoog.model.enums.Measurement;
import org.joomoog.model.enums.State;

public class Ingredient {
    private int id;
    private String name;
    private State state;
    private NutritionalProfile nutritionalProfile;

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setState(State state) {
        this.state = state;
    }
    public void setNutritionalProfile(NutritionalProfile nutritionalProfile) {
        this.nutritionalProfile = nutritionalProfile;
    }

    @Override
    public String toString() {
        return "Ingredient {" +
                "id:" + id +
                ", name:'" + name + '\'' +
                ", state:" + state +
                ", nutritionalProfile:" + nutritionalProfile +
                '}';
    }
}
