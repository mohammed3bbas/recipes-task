package com.example.recipes.repo;

import com.example.recipes.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepo  extends JpaRepository<Category, Long> {


    List<Category> findByName(String name);

//    @Query(value = "select c.name from category c", nativeQuery= true)
//    List<String> getAllNames();
}

