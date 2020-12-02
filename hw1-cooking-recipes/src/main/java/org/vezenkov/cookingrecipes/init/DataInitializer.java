package org.vezenkov.cookingrecipes.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.vezenkov.cookingrecipes.dao.RecipeRepository;
import org.vezenkov.cookingrecipes.model.Gender;
import org.vezenkov.cookingrecipes.model.Recipe;
import org.vezenkov.cookingrecipes.model.User;
import org.vezenkov.cookingrecipes.service.UserService;

import java.util.List;
import java.util.Set;

import static org.vezenkov.cookingrecipes.model.Role.*;

@Component
public class DataInitializer implements CommandLineRunner {
    private final UserService userService;

    private final RecipeRepository recipeRepository;


    private static final List<User> SAMPLE_USERS = List.of(
            new User("ADMIN", "admin", "admin_123", Gender.OTHER, Set.of(USER, ADMIN)),
            new User("Gordon Ramsey", "ramsey", "best_cook123", Gender.MALE, Set.of(USER), "https://www.gstatic.com/tv/thumb/persons/319794/319794_v9_bb.jpg", "mE swear very often"),
            new User("Default", "default", "default_1", Gender.FEMALE)
    );

    private final static List<Recipe> SAMPLE_RECIPES = List.of(
            new Recipe("Scrambled eggs", "Healthy breakfast...", "Easy recipe for scrambling eggs like a pro.", 15, Set.of("eggs", "olive oil", "salt"), "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/recipe-image-legacy-id-1201452_12-7f7a0fa.jpg?quality=90&webp=true&resize=300,272"),
            new Recipe("Purjeni kartofki", "recepta za purjene na kartofi", "super healthy purjeni kartofi", 45, Set.of("kartofi", "mnogo olio"), "image/png;base64,SGVsbG8sIFdvcmxkIQ=="),
            new Recipe("Shkembe chorba", "... s mnogo chesun i ocet", "perfektnoto qdene za purva sreshta", 180, Set.of("mleko", "shkembe", "predpolagam i drugi neshta?"), "text/html,<script>alert('hi');</script>")
    );

    @Autowired
    public DataInitializer(UserService userService, RecipeRepository recipeRepository) {
        this.userService = userService;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.userService.getCount() == 0) {
            SAMPLE_USERS.forEach(this.userService::addUser);
        }

        if (this.recipeRepository.count() == 0) {
            SAMPLE_RECIPES.forEach(recipe -> {
                recipe.setAuthorId(this.userService.getUserByUsername("ramsey").getId());
                this.recipeRepository.insert(recipe);
            });
        }
    }
}
