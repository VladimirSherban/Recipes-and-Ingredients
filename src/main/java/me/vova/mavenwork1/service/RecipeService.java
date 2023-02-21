package me.vova.mavenwork1.service;

import me.vova.mavenwork1.model.Recipe;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

public interface RecipeService {

    Recipe save(Recipe recipe);

    Optional<Recipe> getById(Long id);

    Recipe update(Long id, Recipe recipe);

    Recipe delete(Long id);

    Map<Long, Recipe> getAll();

    /**
     * Чтение файла рецептов
     *
     * @return файл рецептов
     */
    File readFile();

    void uploadFile(MultipartFile file) throws IOException;

    File prepareRecipesTxt() throws IOException;
}
