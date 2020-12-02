package org.vezenkov.cookingrecipes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.vezenkov.cookingrecipes.exception.InvalidEntityDataException;
import org.vezenkov.cookingrecipes.model.Recipe;
import org.vezenkov.cookingrecipes.service.RecipeService;

import javax.validation.Valid;
import java.util.List;

import static org.vezenkov.cookingrecipes.util.ErrorHandlingUtil.getViolationsAsStringList;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<Recipe> getALlRecipes() {
        return this.recipeService.getAllRecipes();
    }

    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable("id") String id) {
        return this.recipeService.getRecipeById(id);
    }

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@Valid @RequestBody Recipe recipe, Errors errors) {
        if (errors.hasErrors()) {
            throw new InvalidEntityDataException("Invalid recipe data", getViolationsAsStringList(errors));
        }

        Recipe created = this.recipeService.addRecipe(recipe);

        return ResponseEntity.created(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .pathSegment("{id}")
                        .buildAndExpand(created.getId())
                        .toUri()
        ).body(created);
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@PathVariable("id") String id, @Valid @RequestBody Recipe recipe, Errors errors) {
        if (errors.hasErrors()) {
            throw new InvalidEntityDataException("Invalid recipe data", getViolationsAsStringList(errors));
        }

        if (!id.equals(recipe.getId())) {
            throw new InvalidEntityDataException(String.format("Recipe ID:%s differs from body entity ID:%s", id, recipe.getId()));
        }

        return this.recipeService.updateRecipe(recipe);
    }

    @DeleteMapping("/{id}")
    public Recipe deleteRecipe(@PathVariable("id") String id) {
        return this.recipeService.deleteRecipeById(id);
    }
}
