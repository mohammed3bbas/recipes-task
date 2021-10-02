package com.example.recipes.repo;

import com.example.recipes.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo  extends JpaRepository<Category, Long> {


    List<Category> findByName(String name);
}

