package com.vezenkov.cookingrecipes.web;

import com.vezenkov.cookingrecipes.entity.Recipe;
import com.vezenkov.cookingrecipes.entity.User;
import com.vezenkov.cookingrecipes.service.RecipeService;
import com.vezenkov.cookingrecipes.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/recipes")
@Slf4j
public class RecipeController {
    public static final String UPLOADS_DIR = "tmp";

    private final RecipeService recipeService;

    private final UserService userService;

    @Autowired
    public RecipeController(RecipeService recipeService, UserService userService) {
        this.recipeService = recipeService;
        this.userService = userService;
    }

    @GetMapping
    public String getAllRecipes(Model model) {
        List<Recipe> allRecipes = this.recipeService.getAllRecipes();
        model.addAttribute("path", "recipes");
        model.addAttribute("recipes", allRecipes);

        log.debug("Recipes queried: {}", allRecipes);
        return "recipes";
    }

    @PostMapping(params = "edit")
    public String editRecipe(@RequestParam("edit") Long editId, RedirectAttributes redirectAttributes) {
        log.debug("Editing article : {}", editId);
        redirectAttributes.addAttribute("mode", "edit");
        redirectAttributes.addAttribute("recipeId", editId);

        return "redirect:/recipes/recipe-form";
    }

    @PostMapping(params = "delete")
    public String deleteRecipe(@RequestParam("delete") Long deleteId) {
        Recipe deleted = this.recipeService.deleteRecipeById(deleteId);
        log.debug("Deleting recipe : {}", deleted);

        return "redirect:/recipes";
    }


    @GetMapping("/recipe-form")
    public String getRecipeForm(@ModelAttribute("recipe") Recipe recipe, Model model) {
        model.addAttribute("path", "recipe-form");
        String title = "Add new Recipe";

        if (model.containsAttribute("mode")) {
            Recipe foundRecipe = this.recipeService.getRecipeById((Long) model.getAttribute("recipeId"));
            foundRecipe.setModified(new Date());

            model.addAttribute("article", foundRecipe);
            title = "Edit Article";
        }

        model.addAttribute("title", title);
        return "recipe-form";
    }

    @PostMapping("/recipe-form")
    public String addArticle(@Valid @ModelAttribute("recipe") Recipe recipe, BindingResult bindingResult, @RequestParam("file") MultipartFile file, Model model, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Enter a valid Recipe");
            model.addAttribute("fileError", null);
            log.error("{}", bindingResult.getFieldErrors());
            return "recipe-form";
        }

        log.info("POST Recipe {}", recipe);

        if (!file.isEmpty() && file.getOriginalFilename().length() > 0) {
            if (Pattern.matches("\\w+\\.(jpg|png)", file.getOriginalFilename())) {
                handleMultipartFile(file);
                recipe.setPictureUrl(file.getOriginalFilename());
            } else {
                model.addAttribute("fileError", "Submit picture [.jpg | .png]");
                return "recipe-form";
            }
        }

        if (recipe.getId() == null) {
            log.info("Add new Recipe: {}", recipe);
            this.recipeService.addRecipe(recipe);
            User currUser = this.userService.getUserByUsername(request.getUserPrincipal().getName());
            recipe.setAuthor(currUser);
        } else {
            recipe.setModified(new Date());
            log.info("Modifying Recipe: {}", recipe);
            this.recipeService.updateRecipe(recipe);
        }

        return "redirect:/recipes";
    }

    private void handleMultipartFile(MultipartFile file) {
        String name = file.getOriginalFilename();
        long size = file.getSize();
        log.info("File {}, size {}", name, size);

        try {
            File currentDir = new File(UPLOADS_DIR);

            if (!currentDir.exists()) {
                currentDir.mkdirs();
            }

            String path = currentDir.getAbsolutePath() + "/" + file.getOriginalFilename();
            path = new File(path).getAbsolutePath();
            log.info(path);

            File f = new File(path);
            FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(f));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
