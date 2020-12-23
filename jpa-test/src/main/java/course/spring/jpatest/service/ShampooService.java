package course.spring.jpatest.service;

import course.spring.jpatest.entity.Ingredient;
import course.spring.jpatest.entity.Shampoo;

import java.util.List;

public interface ShampooService {

    List<Shampoo> findShampoosBySize(int size);

    List<Shampoo> findShampoosByPriceGreaterThan(double price);

    List<Shampoo> findShampoosByPriceBetween(double lowerBound, double upperBound);

    List<Shampoo> findShampoosByIngredientsContaining(Ingredient ingredient);

    // TODO add CRUD methods
}
