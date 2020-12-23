package course.spring.jpatest.service;

import course.spring.jpatest.entity.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> findAll();

    Ingredient findById(Long id);

    //TODO all other CRUD methods
}
