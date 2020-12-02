package org.vezenkov.cookingrecipes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.vezenkov.cookingrecipes.dao.RecipeRepository;
import org.vezenkov.cookingrecipes.exception.NonExistingEntityException;
import org.vezenkov.cookingrecipes.model.Recipe;
import org.vezenkov.cookingrecipes.model.Role;
import org.vezenkov.cookingrecipes.model.User;
import org.vezenkov.cookingrecipes.service.RecipeService;
import org.vezenkov.cookingrecipes.service.UserService;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {
    private static final String UNAUTHORIZED_EXC = "Cannot %s post unless you are an admin or you have written the recipe";
    private final RecipeRepository recipeRepository;

    private final UserService userService;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository, UserService userService) {
        this.recipeRepository = recipeRepository;
        this.userService = userService;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return this.recipeRepository.findAll();
    }

    @Override
    public Recipe getRecipeById(String id) {
        return this.recipeRepository.findById(id)
                .orElseThrow(() -> new NonExistingEntityException(String.format("Recipe with ID:%s does not exist.", id)));
    }

    @Override
    public Recipe addRecipe(Recipe recipe) {
        recipe.setId(null);
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        recipe.setAuthorId(this.userService.getUserByUsername(username).getId());
        return this.recipeRepository.insert(recipe);
    }

    @Override
    public Recipe updateRecipe(Recipe recipe) {
        this.getRecipeById(recipe.getId());
        recipe.setModified(LocalDateTime.now());
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = this.userService.getUserByUsername(username);

        if (!recipe.getAuthorId().equals(user.getId()) && !user.getRoles().contains(Role.ADMIN)) {
            throw new BadCredentialsException(String.format(UNAUTHORIZED_EXC, "update"));
        }

        return this.recipeRepository.save(recipe);
    }

    @Override
    public Recipe deleteRecipeById(String id) {
        Recipe deleted = this.getRecipeById(id);

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = this.userService.getUserByUsername(username);

        if (!deleted.getAuthorId().equals(user.getId()) && !user.getRoles().contains(Role.ADMIN)) {
            throw new BadCredentialsException(String.format(UNAUTHORIZED_EXC, "delete"));
        }

        this.recipeRepository.deleteById(id);
        return deleted;
    }

    @Override
    public long getCount() {
        return this.recipeRepository.count();
    }
}
