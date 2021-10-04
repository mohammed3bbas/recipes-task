package com.example.recipes.repo;

import com.example.recipes.model.Category;
import com.example.recipes.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RecipeRepo extends JpaRepository<Recipe, Long> {


    List<Recipe> findByNameContainingIgnoreCase(String name);


    List<Recipe> findByCategory(Category category);

    Optional<Recipe> findById(Long id);

    @Query(value = "select r.name from recipe r", nativeQuery= true)
    List<String> getAllNames();
}
