package me.vova.mavenwork1.service;

import me.vova.mavenwork1.model.Recipe;

import java.util.Optional;

public interface RecipeService {

    Recipe save(Recipe recipe);

    Optional<Recipe> getById(Long id);
}
