package org.joomoog;

import org.joomoog.model.Ingredient;
import org.joomoog.model.NutritionalProfile;
import org.joomoog.model.Recipe;
import org.joomoog.model.enums.Measurement;
import org.joomoog.model.enums.Protein;
import org.joomoog.repository.Repository;

public class Main {
    public static void main(String[] args) {

        Repository repository = new Repository();
        repository.createDatabase();
    }
}