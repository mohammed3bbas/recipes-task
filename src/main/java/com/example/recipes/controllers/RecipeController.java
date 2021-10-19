package com.example.recipes.controllers;

import com.example.recipes.DTO.RecipeDTO;
import com.example.recipes.model.Recipe;
import com.example.recipes.service.CategoryServices;
import com.example.recipes.service.RecipeServices;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
//    @Autowired

    private final RecipeServices recipeServices;
    private final CategoryServices categoryServices;


    public RecipeController(RecipeServices recipeServices, CategoryServices categoryServices) {
        this.recipeServices = recipeServices;
        this.categoryServices = categoryServices;
    }

    @GetMapping()
    public List<Recipe> getAllRecipes() {
//        System.out.println(recipeServices.findAllRecipes().toString());
        return recipeServices.findAllRecipes();

    }

    @GetMapping("/{id}")
    public Optional<Recipe> getRecipeById(@PathVariable("id") Long id) {
        return recipeServices.findRecipeById(id);

    }

    @GetMapping("/")
    public List<Recipe> getRecipesByName(@RequestParam String name) {

        return recipeServices.findRecipesByName(name);

    }

    @GetMapping("/category")
    public List<Recipe> getRecipesByCategoryName(@RequestParam String name) {
        return recipeServices.findRecipesByCategory(categoryServices.findCategoryByName(name));
    }


    @PostMapping("")
    public Recipe addRecipe(@RequestBody RecipeDTO recipe) throws Exception {
        return recipeServices.addRecipe(recipe);
//        return newRecipe;
    }

    @PutMapping("")
    public Recipe updateRecipe(@RequestBody RecipeDTO recipe) throws Exception {
        return recipeServices.updateRecipe(recipe);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id){
        recipeServices.deleteRecipeById(id);
//        return "Success";
    }


}
