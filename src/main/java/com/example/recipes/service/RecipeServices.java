package com.example.recipes.service;

import com.example.recipes.model.Category;
import com.example.recipes.model.Recipe;
import com.example.recipes.repo.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RecipeServices {
//    @Autowired
    private final RecipeRepo recipeRepo;

    public RecipeServices(RecipeRepo recipeRepo)

    {
        this.recipeRepo = recipeRepo;
    }

//  C : CREATE
    public Recipe addRecipe(Recipe recipe){

        return recipeRepo.save(recipe);
    }
//  R : READ
    public List<Recipe> findAllRecipes(){

        return recipeRepo.findAll();
    }
    public Optional<Recipe> findRecipeById(Long id)
    {
        return recipeRepo.findById(id);

    }
    public  List<Recipe> findRecipesByName(String name){
        return recipeRepo.findByNameContainingIgnoreCase(name);
    }

    public List<Recipe> findRecipesByCategory(Category category){
        return recipeRepo.findByCategory(category);
    }

//   U : UPDATE
    public Recipe updateRecipe(Recipe recipe)
    {

        return recipeRepo.save(recipe);
    }
//  D: DELETE
    public void deleteRecipe(Recipe recipe){
        recipeRepo.delete(recipe);

    }
    public void deleteRecipeById(Long id){

        recipeRepo.deleteById(id);
    }



}
