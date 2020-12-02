package org.vezenkov.cookingrecipes.service;

import org.vezenkov.cookingrecipes.model.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAllRecipes();

    Recipe getRecipeById(String id);

    Recipe addRecipe(Recipe recipe);

    Recipe updateRecipe(Recipe recipe);

    Recipe deleteRecipeById(String id);

    long getCount();
}
