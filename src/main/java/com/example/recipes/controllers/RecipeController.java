package com.example.recipes.controllers;

import com.example.recipes.model.Recipe;
import com.example.recipes.service.CategoryServices;
import com.example.recipes.service.RecipeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    @Autowired

    private final RecipeServices recipeServices ;
    private final CategoryServices categoryServices;




    public RecipeController(RecipeServices recipeServices, CategoryServices categoryServices) {
        this.recipeServices = recipeServices;
        this.categoryServices = categoryServices;
    }

    @GetMapping()
    public List<Recipe> getAllRecipes(){
        List<Recipe> recipes = recipeServices.findAllRecipes();
        return recipes;
    }

    @GetMapping("/{id}")
    public Optional<Recipe> getRecipeById(@PathVariable("id") Long id){
        return recipeServices.findRecipeById(id);

    }

    @GetMapping("/")
    public List<Recipe> getRecipesByName(@RequestParam String name){

        return recipeServices.findRecipesByName(name);

    }

    @GetMapping("/category")
    public List<Recipe> getRecipesByCategoryName(@RequestParam String name){
        return recipeServices.findRecipesByCategory(categoryServices.findCategoryByName(name));
    }



    @PostMapping("")
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        Recipe newRecipe = recipeServices.addRecipe(recipe);
        return newRecipe;
    }






}
