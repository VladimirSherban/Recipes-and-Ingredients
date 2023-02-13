package me.vova.mavenwork1.service;

import me.vova.mavenwork1.model.Ingredient;
import me.vova.mavenwork1.model.Recipe;

public interface ValidationService {

    public boolean validate(Recipe recipe);

    public boolean validate(Ingredient ingredient);
}
