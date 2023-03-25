package me.vova.mavenwork1.model;

import lombok.*;

import java.util.List;


@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    private String name;
    private int cookingTime;
    protected List<Ingredient> ingredients;
    private List<String> steps;

    @Override
    public String toString() {
        return name + "\n Время приготовления: " + cookingTime;
    }
}
