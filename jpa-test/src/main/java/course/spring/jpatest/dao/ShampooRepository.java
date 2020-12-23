package course.spring.jpatest.dao;

import course.spring.jpatest.entity.Ingredient;
import course.spring.jpatest.entity.Shampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> findAllBySize(int size);

    List<Shampoo> findAllByPriceGreaterThan(double price);

    List<Shampoo> findAllByPriceBetween(double lowerBound, double upperBound);

    List<Shampoo> findAllByIngredientsContaining(Ingredient ingredient);
}
