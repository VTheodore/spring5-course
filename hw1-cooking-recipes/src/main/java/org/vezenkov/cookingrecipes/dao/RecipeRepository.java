package org.vezenkov.cookingrecipes.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.vezenkov.cookingrecipes.model.Recipe;

@Repository
public interface RecipeRepository extends MongoRepository<Recipe, String> {
}
