package com.vezenkov.cookingrecipes.service;

import com.vezenkov.cookingrecipes.entity.Recipe;

import javax.validation.Valid;
import java.util.List;

public interface RecipeService {
    List<Recipe> getAllRecipes();

    Recipe getRecipeById(Long id);

    Recipe addRecipe(Recipe recipe);

    Recipe updateRecipe(Recipe recipe);

    Recipe deleteRecipeById(Long id);

    long recipesCount();
}
