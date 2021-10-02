package com.example.recipes.repo;

import com.example.recipes.model.Category;
import com.example.recipes.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepo extends JpaRepository<Recipe, Long> {


    List<Recipe> findByNameContainingIgnoreCase(String name);


    List<Recipe> findByCategory(Category category);
}
