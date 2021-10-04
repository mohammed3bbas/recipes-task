package com.example.recipes.service;

import com.example.recipes.DTO.RecipeDTO;
import com.example.recipes.model.Category;
import com.example.recipes.model.Recipe;
import com.example.recipes.repo.CategoryRepo;
import com.example.recipes.repo.RecipeRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RecipeServices {

    private final RecipeRepo recipeRepo;
    private final CategoryRepo categoryRepo;

    public RecipeServices(RecipeRepo recipeRepo, CategoryRepo categoryRepo) {
        this.recipeRepo = recipeRepo;
        this.categoryRepo = categoryRepo;
    }

    //  C : CREATE
    public Recipe addRecipe(RecipeDTO recipeDTO) throws Exception {


        if(! recipeNameValid(recipeDTO.getName())){
            return null;
        }


        Recipe recipe = new Recipe();

        recipe.setName(recipeDTO.getName());
        recipe.setImageUrl(recipeDTO.getImageUrl());
        recipe.setMinutes(recipeDTO.getMinutes());

        if (recipeDTO.getCategoryId() != 0) {
            Category category = categoryRepo.findById(recipeDTO.getCategoryId()).orElseThrow(()->new RuntimeException("id invalid"));
            recipe.setCategory(category);
        } else {
            recipe.setCategory(null);
        }


        return recipeRepo.save(recipe);

    }

    private boolean recipeNameValid(String name) {
        return !findRecipeNames().contains(name) && name != null && name.length() < 50;
    }

    //  R : READ
    public List<Recipe> findAllRecipes() {

        return recipeRepo.findAll();
    }

    public Optional<Recipe> findRecipeById(Long id) {
        return recipeRepo.findById(id);

    }

    public List<Recipe> findRecipesByName(String name) {
        return recipeRepo.findByNameContainingIgnoreCase(name);
    }

    public List<Recipe> findRecipesByCategory(Category category) {
        return recipeRepo.findByCategory(category);
    }

    private List<String> findRecipeNames(){
        return recipeRepo.getAllNames();
    }

    //   U : UPDATE
    public Recipe updateRecipe(RecipeDTO recipeDTO) throws Exception {
        Optional<Recipe> recipe = recipeRepo.findById(recipeDTO.getRecipeId());
        if (recipe.isPresent()) {
            Recipe wantedRecipe = recipe.get();

            wantedRecipe.setName(recipeDTO.getName());
            wantedRecipe.setImageUrl(recipeDTO.getImageUrl());
            wantedRecipe.setMinutes(recipeDTO.getMinutes());

            if (recipeDTO.getCategoryId() != 0) {

                Category category = categoryRepo.findById(recipeDTO.getCategoryId()).orElseThrow(()->new EntityNotFoundException("id invalid"));

                wantedRecipe.setCategory(category);
            } else {
                wantedRecipe.setCategory(null);
            }
            return wantedRecipe;
        } else {
            throw new Exception("no recipe found");
        }

    }

    //  D: DELETE
    public void deleteRecipe(Recipe recipe) {
        try {
            recipeRepo.delete(recipe);

        } catch (Exception e) {
            throw e;
        }


    }

    public String deleteRecipeById(Long id) {
        try {
            recipeRepo.deleteById(id);
            return "Success";
        } catch (Exception e) {
            return e.toString();
        }


    }


}
