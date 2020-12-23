package course.spring.jpatest.service.impl;

import course.spring.jpatest.dao.IngredientRepository;
import course.spring.jpatest.entity.Ingredient;
import course.spring.jpatest.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> findAll() {
        return this.ingredientRepository.findAll();
    }

    @Override
    public Ingredient findById(Long id) {
        return this.ingredientRepository.findById(id).orElse(null);
    }
}
