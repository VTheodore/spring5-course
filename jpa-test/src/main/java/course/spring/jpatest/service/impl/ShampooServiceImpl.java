package course.spring.jpatest.service.impl;

import course.spring.jpatest.dao.ShampooRepository;
import course.spring.jpatest.entity.Ingredient;
import course.spring.jpatest.entity.Shampoo;
import course.spring.jpatest.service.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ShampooServiceImpl implements ShampooService {

    private final ShampooRepository shampooRepository;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<Shampoo> findShampoosBySize(int size) {
        return this.shampooRepository.findAllBySize(size);
    }

    @Override
    public List<Shampoo> findShampoosByPriceGreaterThan(double price) {
        return this.shampooRepository.findAllByPriceGreaterThan(price);
    }

    @Override
    public List<Shampoo> findShampoosByPriceBetween(double lowerBound, double upperBound) {
        return this.shampooRepository.findAllByPriceBetween(lowerBound, upperBound);
    }

    @Override
    public List<Shampoo> findShampoosByIngredientsContaining(Ingredient ingredient) {
        return this.shampooRepository.findAllByIngredientsContaining(ingredient);
    }
}
