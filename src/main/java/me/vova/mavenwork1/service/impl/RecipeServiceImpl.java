package me.vova.mavenwork1.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import me.vova.mavenwork1.exception.ValidationException;
import me.vova.mavenwork1.model.Recipe;
import me.vova.mavenwork1.service.RecipeService;
import me.vova.mavenwork1.service.ValidationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private static long idCounter = 1;
    private Map<Long, Recipe> recipes = new HashMap<>();
    private final ValidationService validationService;
    private final FileService fileService;

    @Value("${path.to.recipes.file}")
    private String recipesFilePath;

    @Value("${name.of.recipes.file}")
    private String recipesFileName;

    private Path recipesPath;

    @Override
    public Recipe save(Recipe recipe) {
        if (validationService.validate(recipe)) {
            throw new ValidationException(recipe.toString());
        }
        recipes.put(idCounter++, recipe);
        fileService.saveMapToFile(recipes, recipesPath);
        return recipe;
    }

    @Override
    public Optional<Recipe> getById(Long id) {
        return Optional.ofNullable(recipes.get(id));
    }

    @Override
    public Recipe update(Long id, Recipe recipe) {
        if (validationService.validate(recipe)) {
            throw new ValidationException(recipe.toString());
        }
        Recipe replace = recipes.replace(id, recipe);
        fileService.saveMapToFile(recipes, recipesPath);
        return replace;
    }

    @Override
    public Recipe delete(Long id) {
        Recipe removed = recipes.remove(id);
        fileService.saveMapToFile(recipes, recipesPath);
        return removed;
    }

    @Override
    public Map<Long, Recipe> getAll() {
        return recipes;
    }

    @PostConstruct
    private void inti() {
        recipesPath = Path.of(recipesFilePath, recipesFileName);
        recipes = fileService.readMapFromFile(recipesPath, new TypeReference<HashMap<Long, Recipe>>() {
        });

    }
}
