package me.vova.mavenwork1.model;

import java.util.List;
import java.util.Objects;

public class Recipe {
    private String name;
    private int cookingTime;
    protected List<Ingredient> ingredientList;
    private List<String> steps;

    public Recipe(String name, int cookingTime, List<Ingredient> ingredientList, List<String> steps) {
        this.name = name;
        this.cookingTime = cookingTime;
        this.ingredientList = ingredientList;
        this.steps = steps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return cookingTime == recipe.cookingTime && Objects.equals(name, recipe.name) && Objects.equals(ingredientList, recipe.ingredientList) && Objects.equals(steps, recipe.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cookingTime, ingredientList, steps);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", cookingTime=" + cookingTime +
                ", ingredientList=" + ingredientList +
                ", steps=" + steps +
                '}';
    }
}
