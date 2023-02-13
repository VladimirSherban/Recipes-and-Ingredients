package me.vova.mavenwork1.service;

import me.vova.mavenwork1.model.Ingredient;
import me.vova.mavenwork1.model.Recipe;

import java.util.Map;
import java.util.Optional;

public interface RecipeService {

    Recipe save(Recipe recipe);

    Optional<Recipe> getById(Long id);

    Recipe update(Long id, Recipe recipe);

    Recipe delete(Long id);

    Map<Long, Recipe> getAll();
}
