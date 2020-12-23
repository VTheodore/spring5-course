package course.spring.jpatest.init;

import course.spring.jpatest.entity.Ingredient;
import course.spring.jpatest.service.IngredientService;
import course.spring.jpatest.service.LabelService;
import course.spring.jpatest.service.ShampooService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CommandLineTests implements CommandLineRunner {

    private final IngredientService ingredientService;

    private final LabelService labelService;

    private final ShampooService shampooService;

    @Autowired
    public CommandLineTests(IngredientService ingredientService, LabelService labelService, ShampooService shampooService) {
        this.ingredientService = ingredientService;
        this.labelService = labelService;
        this.shampooService = shampooService;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("All labels: {}", this.labelService.findAll());
        log.info("All ingredients: {}", this.ingredientService.findAll());

        int size = 0;
        log.info("All shampoos with size of {}: {}", size, this.shampooService.findShampoosBySize(size));

        double lowerBound = 3.5;
        double upperBound = 5;
        log.info("All shampoos with price greater than {}: {}", upperBound, this.shampooService.findShampoosByPriceGreaterThan(upperBound));
        log.info("All shampoos with price between {} and {} : {}", lowerBound, upperBound, this.shampooService.findShampoosByPriceBetween(lowerBound, upperBound));

        Ingredient ingredient = this.ingredientService.findById(1L);
        log.info("All shampoos containing ingredient {}: {}", ingredient, this.shampooService.findShampoosByIngredientsContaining(ingredient));
    }
}
