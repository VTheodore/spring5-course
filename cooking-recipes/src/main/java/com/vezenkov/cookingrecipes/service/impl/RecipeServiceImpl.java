package com.vezenkov.cookingrecipes.service.impl;

import com.vezenkov.cookingrecipes.dao.RecipeRepository;
import com.vezenkov.cookingrecipes.entity.Recipe;
import com.vezenkov.cookingrecipes.exception.NonExistingEntityException;
import com.vezenkov.cookingrecipes.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return this.recipeRepository.findAll();
    }

    @Override
    public Recipe getRecipeById(Long id) {
        return this.recipeRepository.findById(id)
                .orElseThrow(() -> new NonExistingEntityException(String.format("Recipe with id=%d does not exist.", id)));
    }

    @Override
    @Transactional
    public Recipe addRecipe(Recipe recipe) {
        recipe.setId(null);
        return this.recipeRepository.save(recipe);
    }

    @Override
    @Transactional
    public Recipe updateRecipe(Recipe recipe) {
        this.getRecipeById(recipe.getId());

        return this.recipeRepository.save(recipe);
    }

    @Override
    @Transactional
    public Recipe deleteRecipeById(Long id) {
        Recipe toBeDeleted = this.getRecipeById(id);
        this.recipeRepository.deleteById(id);

        return toBeDeleted;
    }

    @Override
    public long recipesCount() {
        return this.recipeRepository.count();
    }
}
